package cn.itcast.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池参数的验证
 */
public class c3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        /*
        //获取DataSource,使用默认配置
        DataSource ds = new ComboPooledDataSource();

        //获取连接
        for (int i = 1; i <=10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+ ":" + conn);

            if (i==5){
                conn.close();
            }
        }
        */
        c3p0Demo2.testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        //获取DataSource,使用指定名称的配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        //获取连接
        for (int i = 1; i <=10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+ ":" + conn);
        }
    }
}
