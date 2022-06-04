package com.review.method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("佩奇");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        //主线程打印五个hi,后终止子线程的休眠
        int i = 0;
        while (i<5){
            Thread.sleep(1000);
            System.out.println("hi" + i);
            i++;
        }
        t.interrupt();
    }
}


class T extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread()+getName() + "吃包子~~~" + i);
            }

            try {
                System.out.println(Thread.currentThread()+getName() + "休眠中~~~");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当该线程执行到一个intercept方法时，可加入自己的业务代码
                System.out.println(Thread.currentThread()+getName() + "被intercept了~~~");
            }
        }
    }
}