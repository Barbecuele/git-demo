package com.bjpowernode.jdbc;

import java.sql.*;

/**
 * 注册驱动的第二种方式
 */
public class JDBCTest02 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接
            String url = "jdbc:mysql://localhost:3306/pay?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
            conn = DriverManager.getConnection(url, "root", "242377mxj");

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
