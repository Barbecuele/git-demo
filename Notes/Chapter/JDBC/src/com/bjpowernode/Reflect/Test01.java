package com.bjpowernode.Reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test01 {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //创建Properties对象
        Properties pro = new Properties();

        //加载配置文件，转换为一个集合
        ClassLoader classLoader = Test01.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("resources/pro.properties");
        pro.load(is);

        //2.获取配置文件当中的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);

        //4.创建对象
        Object obj = cls.newInstance();

        //5.获取方法对象
        Method method = cls.getMethod(methodName);

        //6.执行方法
        method.invoke(obj);
    }
}
