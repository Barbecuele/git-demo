package com.review.syn;

public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
    }
}

class SellTicket01 implements Runnable {
//class SellTicket01 extends Thread{
        private static int ticketNum=100;
    private boolean flag=true;

//    public synchronized void sell(){//同步方法，在同一时刻，只能有一个线程来执行该方法

//        if (ticketNum<=0){
//            System.out.println("售票结束");
//            flag=false;
//            return;
//        }
//
//        //模拟休眠50ms
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName() + "售出一张票" + "剩余票数" + (--ticketNum));

    public void sell(){//同步方法，在同一时刻，只能有一个线程来执行该方法
        synchronized (this) {
            if (ticketNum<=0){
                System.out.println("售票结束");
                flag=false;
                return;
            }
            //模拟休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "售出一张票" + "剩余票数" + (--ticketNum));
        }

    }

    @Override
    public void run() {

        while (flag){
            sell();
        }
    }
}