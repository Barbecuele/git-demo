package com.itheima.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        //获得目标对象
        final Target target = new Target();

        //获得增强对象
        final Advice advice = new Advice();
        //返回值就是生成的动态代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //目标对象的类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //调用代理对象的任何方法，实质执行的都是invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //执行目标方法
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        advice.afterReturning();
                        return invoke;
                    }
                }

        );
        proxy.save();
        proxy.fuck();
    }
}
