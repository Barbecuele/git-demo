package com.bjpowernode.jdbc;

import com.bjpowernode.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 在当前事务中对job=‘manager'的记录进行查询并锁定，使用行级锁机制
 *
 * 在mysql中是这样的（Oracle中不是这样的）：
 * 当使用select ... for update ...where ...时，mysql进行row lock
 * 还是table lock只取决于是否能使用索引（例如主键，unique字段），能则为行锁，
 * 否则为表锁；未查到数据则无锁。而 使用'<>','like'等操作时，索引会失效，自
 * 然进行的是table lock
 *
 * 所以慎用for update。
 */
public class JDBCTest11 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            String sql = "select ename,sal from emp where empno = ? for update";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, 7369);

            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("ename") + "," + rs.getString("sal"));
            }

            Thread.sleep(1000*20);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtil.close(conn, ps, rs);
        }
    }
}
