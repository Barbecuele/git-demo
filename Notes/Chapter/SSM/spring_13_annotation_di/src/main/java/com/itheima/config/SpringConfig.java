package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itheima")
//@PropertySource加载properties配置文件,不支持使用通配符*
@PropertySource({"jdbc.properties"})
public class SpringConfig {
}
