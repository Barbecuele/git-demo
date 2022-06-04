package com.itheima.proxy.jdk;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }

    @Override
    public void fuck() {
        System.out.println("fuck you!");
    }
}
