package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 使用PrepareStatement做模糊查询
 */
public class JDBCTest07 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //绑定资源管理器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/db");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url,user,password);

            //找出名字中含有O的
            /*错误的，？不能出现在单引号里面
            String sql = "select ename from emp where ename like '%?%'";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"o");
            */

            //重点是占位符该怎么写！！！
            String sql = "select ename from emp where ename like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"S%");
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("ename"));
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
