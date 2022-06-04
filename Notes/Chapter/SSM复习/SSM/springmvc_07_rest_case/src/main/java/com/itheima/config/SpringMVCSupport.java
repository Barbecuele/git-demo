package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMVCSupport extends WebMvcConfigurationSupport {

    @Override//添加资源过滤
    /* 如果访问路径是addResourceHandler中的filepath 这个路径 那么就
       映射到访问本地的addResourceLocations 的参数的这个路径上，这样就可以让别人访问服务器的本地文件了
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        //当访问pages目录下的资源时，希望不通过mvc，直接对pages目录下的资源资进行访问
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}
