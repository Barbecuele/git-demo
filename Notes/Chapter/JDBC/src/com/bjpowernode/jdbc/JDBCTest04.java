package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 模拟用户登录
 * <p>
 * 用户名:admin
 * 密码:fdsa' or '1' =1
 * select *from t_user where login_name = 'admin ' and login_pwd = 'fsda' or '1'='1';
 * 登录成功
 *
 * 以上随意输入一个用户名和密码，登录成功了，这种现象被称为SQl注入现象
 *
 * 导致SQl注入的原因是什么？怎么解决呢？
 *      导致SQL注入的根本原因是：用户不是一般的用户，是懂得程序的用户，输入的用户信息以及密码信息中含有SQL语句的关键字
 *      这个SQL语句的关键字和底层的SQL语句进行“字符串拼接”，导致原SQL语句的含义被扭曲了。最最最最最重要的原因是：用户
 *      提供的信息参与了SQL语句的编译。
 *
 * 主要因素是：这个程序是先进行字符串的拼接，然后再进行SQL语句的编译，正好被注入
 */
public class JDBCTest04 {
    /**
     * 初始化用户登录界面，并且接收用户的输入
     *
     * @return 包含用户信息的Map集合
     */
    private static Map<String, String> initUI() {
        System.out.println("****************请输入一个用户名和密码进行身份验证****************");
        Scanner sc = new Scanner(System.in);
        System.out.print("用户名:");
        String loginName = sc.next();
        System.out.print("密码:");
        String loginPwd = sc.next();

        //将用户名和密码放入到Map集合当中
        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        //返回Map
        return userLoginInfo;
    }

    public static void main(String[] args) {
        //初始化一个界面，可以让用户输入用户名和密码
        Map<String, String> userLoginInfo = initUI();

        //连接数据库，验证用户名和密码是否正确
        boolean isOk = checkNameAndPwd(userLoginInfo.get("loginName"), userLoginInfo.get("loginPwd"));
        System.out.println(isOk ? "登录成功" : "登录失败");
    }

    /**
     * 验证用户名和密码
     *
     * @param loginName 用户名
     * @param loginPwd  面
     * @return true表示登录成功，false表示登录失败
     */
    private static boolean checkNameAndPwd(String loginName, String loginPwd) {
        boolean isOk = false;//默认登录失败
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        //资源绑定器
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/db");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        //注册驱动
        try {
            Class.forName(driver);

            //获取连接
            conn = DriverManager.getConnection(url, user, password);

            //获取数据库操作对象
            statement = conn.createStatement();

            //执行SQL语句
            String sql = "select *from t_user where login_name = '" + loginName + " ' and login_pwd = '" + loginPwd + "'";
            System.out.println(sql);

            //程序执行到此处，才会将以上的SQL语句发送到DBMS上。DBMS进行SQL语句的编译。
            resultSet = statement.executeQuery(sql);

            //处理查询结果集
            //如果以上SQL语句用户名密码正确。那么结果最多查询出一条记录。
            if (resultSet.next()) {
                isOk = true;
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
        return isOk;
    }
}
