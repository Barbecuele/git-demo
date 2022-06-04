package com.review.exit_;

public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 st01 = new SellTicket01();
        SellTicket01 st02 = new SellTicket01();
        SellTicket01 st03 = new SellTicket01();

        st01.setName("窗口1");
        st02.setName("窗口2");
        st03.setName("窗口3");
        st01.start();
        st02.start();
        st03.start();
    }
}

class SellTicket01 extends Thread{

    private static int ticketNum=100;
    @Override
    public void run() {

        while (true){
            if (ticketNum<=0){
                System.out.println("售票结束");
                break;
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
}