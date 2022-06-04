package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 在怎么避免SQL注入？
 * SQL注入的根本原因：先进行了字符串的拼接，然后再进行SQL语句的编译
 *
 * java.sql.Statement接口的特点：先进行了字符串的拼接，然后再进行SQL语句的编译
 *      优点：使用Statement可以进行SQL语句的拼接
 *      缺点：因为拼接的存在，导致给不法分子以机会。导致SQL注入
 *
 * java.sql.PreparedStatement接口的特点,先进行SQL语句的编译，然后再进行SQL语句的传值
 *      优点：避免SQL注入
 *      缺点：没有办法进行SQL语句的拼接，只能给SQL语句传值
 *
 *      PreparedStatement预编译的数据库操作对象。
 */
public class JDBCTest05 {
    /**
     * 初始化用户登录界面，并且接收用户的输入
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
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);

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
        PreparedStatement statement = null;
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

            //获取预编译数据库操作对象
            //注意：一个问号？是一个占位符，一个占位符只能接受一个“值/数据"=”
            String sql = "select *from t_user where login_name = ? and login_pwd = ?";

            statement=conn.prepareStatement(sql);//此时会进行SQL语句的发送，给DBMS，进行SQL语句的编译
            //给占位符传值
            statement.setString(1,loginName);
            statement.setString(2,loginPwd);

            //怎么解决SQL注入的：即使用户输入信息里有关键字，但是不参加编译就没事
            resultSet = statement.executeQuery();

            //处理查询结果集
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
