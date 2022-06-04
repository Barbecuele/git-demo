package com.bjpowernode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * JDBC默认情况下对事物是怎么进行处理的？
 * 模拟一下银行账户转账操作，A账户向B账户转账10000元
 * 从A减去10000，给B加10000
 * 必须同时成功或者同时失败
 *
 *
 * 转账需要执行两条update语句的
 *
 * JDBC默认情况下支持自动提交
 *      什么叫自动提交呢?
 *      只要执行一条DML语句就自动提交一次。
 *
 *在实际开发中必须将JDBC的自动提交机制关闭掉，改成手动提交
 * 当一个完整的事务结束之后，再提交
 *      conn.setAutoCommit(false);关闭自动提交机制
 */
public class JDBCTest08 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        //绑定资源管理器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/db");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);

            String sql = "update t_cat set balance =? where actno = ?";
            ps=conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ps.setDouble(1, 10000);
            ps.setString(2, "A");

            //给?传值
            int count = ps.executeUpdate();//更新成功之后表示更新一条，返回1

            String s = null;
            s.toString();
            //JDBC默认情况下自动提交

            //给?传值
            ps.setDouble(1, 10000);
            ps.setString(2, "B");

            count+=ps.executeUpdate();//更新成功之后表示更新一条，返回2

            System.out.println(count==2? "更新成功" : "更新失败");

            //方法能够执行到此处，说明上面的代码没有出现任何异常，表示都成功了，可以提及
            //手动提交，事务结束
            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //释放资源
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