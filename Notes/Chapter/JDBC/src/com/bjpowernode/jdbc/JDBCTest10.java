package com.bjpowernode.jdbc;

import com.bjpowernode.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试DBUtil工具类
 */
public class JDBCTest10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtil.getConnection();

            //获取数据库预编译的操作对象
            String sql = "select ename,sal from emp where ename like ?";
            ps=conn.prepareStatement(sql);

            //给？传值
            ps.setString(1,"A%");

            //执行SQL
            rs = ps.executeQuery();

            //处理结果集
            while (rs.next()){
                System.out.println(rs.getString("ename") + "," + rs.getString("sal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }
    }
}
