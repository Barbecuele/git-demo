package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 将数据库的可变化的四条信息写到配置文件当中
 * 以后想要连接其他数据库的时候可以直接修改配置文件，不需要修改java代码
 * 四个信息是什么？
 *  driver
 *  url
 *  user
 *  password
 */
public class JDBCTest03 {
    public static void main(String[] args) {
        //资源绑定器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/db");

        //通过属性配置文件拿到信息
        String driver = resourceBundle.getString("driver");
        String url= resourceBundle.getString("url");
        String user= resourceBundle.getString("user");
        String password= resourceBundle.getString("password");

        Statement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        try {
            //注册驱动
            Class.forName(driver);

            //获取连接
            conn = DriverManager.getConnection(url, user, password);

            //获取数据库操作对象
            statement = conn.createStatement();

            //执行SQL语句
            String sql = "select a.ename as '员工',b.ename as '领导' from emp a join emp b on a.mgr = b.empno ";

            resultSet = statement.executeQuery(sql);

            //处理查询结果集
            while (resultSet.next()){
                String aename = resultSet.getString("员工");
                String bename = resultSet.getString("领导");
                System.out.println(aename + "," + bename);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
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
