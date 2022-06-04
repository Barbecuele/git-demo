package com.review.method;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new T3());
        for (int i = 1; i <=10; i++) {
            Thread.sleep(1000);
            System.out.println("main hi " + i);
            if (i == 5) {
                t.start();
                t.join();
            }
        }
    }
}

class T3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <=10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "hello" + i);
        }
    }
}