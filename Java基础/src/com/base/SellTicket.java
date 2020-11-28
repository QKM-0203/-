package com.base;


import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable {
    private static int TICKET=100;
    ReentrantLock l=new ReentrantLock();
    //同步代码块的
    //Object o=new Object();
    @Override
    public void run() {

        while (true) {
            //同步代码块
            /*synchronized (o) {
                 if (TICKET > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在买票" + TICKET);
                    TICKET--;
                }
            }*/


            //同步方法
            //payTicket();




            /*Lock
             l.lock();//获取锁
                 if (TICKET > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在买票" + TICKET);
                    TICKET--;
                }

            l.unlock();//释放锁
           */

            //Lock更好的写法


            l.lock();//获取锁
            if (TICKET > 0) {

                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "正在买票" + TICKET);
                    TICKET--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    l.unlock();//释放锁//写在finally里面的好处就是无论程序是否异常都释放锁
                }

            }





        }
    }

    /*加上关键字static也是可以的
    public static synchronized void  payTicket(){
        if (TICKET > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在买票" + TICKET);
            TICKET--;
        }
    }*/
}
