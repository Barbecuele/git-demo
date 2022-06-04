package cn.itcast.dataSource.Druid;

import cn.itcast.dataSource.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        /*
        完成添加的操作,给表t_cat添加一条记录
         */
        //获取连接
        try {
            conn = JDBCUtil.getConnection();

            //定义SQL
            String sql = "insert into t_cat(actno,balance)values(?,?)";

            //获取PrepareStatement对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, "E");
            ps.setDouble(2, 100);

            int count = ps.executeUpdate();

            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源，归还连接
            JDBCUtil.close(null,ps,conn);
        }
    }
}
