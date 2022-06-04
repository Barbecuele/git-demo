package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 测试PrepareStatement
 */
public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        //资源绑定器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/db");

        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        try {
            //注册驱动
            Class.forName(driver);

            //获取连接
            conn = DriverManager.getConnection(url,user,password);

            //获取预编译数据库操作对象
            String sql = "select sal from emp where ename = ?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,"smith");

            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("sal"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
