package com.base;
//线程的第二种实现方式，实现Runable接口，实现Run方法，然后开启
//线程需要创建实现Runable的类的对象，通过Thread的构造方法传递该对象new一个Thread的对象出来调用start方法就可以


public class thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
