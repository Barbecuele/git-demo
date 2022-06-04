package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 需求：在控制台上输入desc则降序，输入asc则进行升序
 * 思考一下：这个应该选择Statement还是PrepareStatement呢？
 * 选Statement，因为PrepareStatement只能传值，不能进行SQL语句的拼接
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入排序规则：【desc代表降序，asc代表升序】");

        String orderKey = sc.next();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        //绑定资源管理器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/db");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        try {
            Class.forName(driver);
            //获取连接
            conn= DriverManager.getConnection(url,user,password);

            //获取数据库操作对象
            statement=conn.createStatement();

            String sql = "select ename,sal from emp order by sal "+ orderKey ;

            resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println(resultSet.getString("ename") + "," + resultSet.getString("sal"));
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