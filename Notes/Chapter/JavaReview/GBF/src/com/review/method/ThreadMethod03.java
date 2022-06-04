package com.review.method;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        T4 t = new T4();
        t.setDaemon(true);
        t.start();
        for (int i = 1; i <=10; i++) {
            System.out.println("main hi " + i);
            Thread.sleep(1000);
        }
    }
}

class T4 extends Thread{
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程hello:" + Thread.currentThread().getName());
        }

    }
}