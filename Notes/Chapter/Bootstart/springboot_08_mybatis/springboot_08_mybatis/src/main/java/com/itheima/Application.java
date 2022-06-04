package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*就是启动了一个Spring容器，我们定义的Bean就可以加载到这里面。*/
        SpringApplication.run(Application.class, args);
    }

}
