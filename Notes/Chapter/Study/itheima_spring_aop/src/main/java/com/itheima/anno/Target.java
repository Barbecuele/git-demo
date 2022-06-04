package com.itheima.anno;

import org.springframework.stereotype.Component;

@Component("target")//需要在配置文件中进行组件扫描
public class Target implements TargetInterface {
    @Override
    public void save() {
        //int i = 1 / 0;
        System.out.println("save running...");
    }

}
