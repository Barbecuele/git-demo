package cn.itheima.config;


import cn.itheima.dao.BookDao;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public class JdbcConfig {

    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;

    @Value("jdbc:mysql://localhost:3306/test?user=root&password=242377mxj&useUnicode=true&characterEncoding=utf8 & useSSL=false & serverTimezone=GMT%2B8 & rewriteBatchedStatements=true")
    private String url;

    @Value("242377mxj")
    private String username;

    @Value("root")
    private String password;
    //1.定义一个方法获得要管理的对象
    //1.添加@Bean，表示当前方法的返回值是一个Bean
    @Bean("dataSource")
    public DataSource dataSource(BookDao bookDao){

        System.out.println(bookDao);

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setPassword(password);
        ds.setUsername(username);
        return ds;
    }
}
