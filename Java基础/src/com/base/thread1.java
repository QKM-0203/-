package com.base;
import javax.imageio.stream.ImageInputStream;

//现在的你写的每一个Java程序是单线程
//主线程，执行主方法的线程，main方法就是主线程
//创建多线程程序
//1 创建一个类继承Thread,重写Thread的run方法
//2实现Runable接口,重写Run方法//在thread2类里面
public class thread1 extends Thread {
    @Override
    public void run() {//设置线程任务
        /*for (int i = 0; i < 10; i++) {
            System.out.println("另一个线程"+i);
        }*/



        //thread获取线程的名字的方法
        //getname()获取线程名称，以下有好几种写法 从0开始依次排序
        //Thread.currentThread()//获取当前线程的对象，如果想获取当前线程的名称在直接调用getname()


        /*
        String name = getName();
        System.out.println(name);*///获取线程名称



        /*Thread thread = currentThread();//获取当前线程对象
        System.out.println(thread);//    Thread[Thread-0,5,main]
        */



        /*
        Thread thread = new Thread();
        String name = thread.getName();
        System.out.println(name);//Thread-1
        */

        System.out.println(Thread.currentThread().getName());//Thread-0//一次获取当前执行线程的名称


         //设置线程名称的方法
         //线程对象.setname();在测试类里面
         //在子类（写的线程类）里面加一个有参的构造方法，通过父类传递名字给子类。
         /*public thread(String name) {
          super(name);
          }*/



        //sleep()//让程序睡眠多少毫秒再继续执行，（再测试类里面可以看见）
    }


    /*puic thread(String name) {
        super(name);
    }*/
}