package com.review.homework;


public class Homework2 {
    public static void main(String[] args) {
        T3 t = new T3();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("t1");
        t2.setName("t2");

        t2.start();
        t1.start();
    }

}

class T3 implements Runnable{
    private static int money = 10000;

    @Override
    public void run() {

            while (true) {
                synchronized (this) {
                    if (money<=0){
                        System.out.println("余额不足，请自行打印流水");
                        break;
                    }else {
                        money-=1000;
                        System.out.println(Thread.currentThread().getName() + "取出1000元，剩余: " + money);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    }

}
