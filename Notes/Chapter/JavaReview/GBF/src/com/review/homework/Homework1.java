package com.review.homework;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);

        t2.start();
        t1.start();
    }

}

class T1 extends Thread{

    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + (int)(Math.random()*100+1));
        }
    }
}

class T2 extends Thread{
    public T1 t ;
    private Scanner sc = new Scanner(System.in);

    public T2(T1 t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("请输入你的指令");
        String str = sc.next();
        while (true){
            if (str.equals("Q")){
                System.out.println("t1线程停止");
                t.setFlag(false);
                break;
            }
        }
    }
}