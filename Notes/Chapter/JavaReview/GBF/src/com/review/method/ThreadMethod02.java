package com.review.method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t = new T2();
        t.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("main hi " + i);
            if (i==4){
                t.join();
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程hello:" + Thread.currentThread().getName() + i);
        }
    }
}