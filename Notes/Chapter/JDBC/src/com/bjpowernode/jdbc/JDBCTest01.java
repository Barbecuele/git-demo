package com.bjpowernode.jdbc;

import java.sql.*;

/**
 * 使用idea开发一个JDBC程序
 */
public class JDBCTest01 {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //获取连接
            String url = "jdbc:mysql://localhost:3306/pay?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            conn = DriverManager.getConnection(url,"root","242377mxj");

            //获取数据库操作对象
            statement = conn.createStatement();

            //执行SQL语句
            String sql = "select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno";

            resultSet = statement.executeQuery(sql);
            //处理查询结果集
            while (resultSet.next()){
                String ename = resultSet.getString("ename");
                String dname = resultSet.getString("dname");
                System.out.println(ename + "," + dname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
