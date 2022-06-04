package com.itheima;

import org.junit.Test;

public class MyTest {

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000*10);
            System.out.println(i);
        }
    }
}
