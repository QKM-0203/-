package com.base;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class textthread {
    public static void main(String[] args) throws InterruptedException {

        //第一种实现多线程的方法
        /*
        thread1 thread = new thread1();//会开辟一个线程，通向cpu的新路径，cpu有两条路径（开辟了两个线程），两个路径一起抢夺cpu执行权，这样就会出现
        //随即打印的结果
        thread.start();//开始一个线程，并且会开辟新的栈空间，不会影响main栈中方法的执行，，并且线程会有优先级，cpu就一直在多个线程转换，输出结果可能随机的
        //调用run方法和start是不一样的run是在main栈里面的,而start会开辟新的栈空间执行，并且线程之间是相互独立的互不影响的。

         thread.setName("戚凯萌");
        for (int i = 0; i < 10; i++) {
            System.out.println("main"+i);
            thread1.sleep(Long.parseLong("1000"));//执行时间会暂停1秒再继续执行
        }

        System.out.println(Thread.currentThread().getName());//获取主线程的名称  //main
        */



        /*第二种实现多线程的方法
        thread2 thread2 = new thread2();//Runable接口的该thread类实现Runable
        Thread th = new Thread(thread2);//创建Thread的对象来调用start方法
        th.start();*/



        //两种线程的区别
        //使用Runable的好处，避免了单继承，并且将开始进程和和设置线程任务进行了分离。Thread里面可以传递不同的实现类对象，就可以调用不同的进程



        //第三种匿名内部类实现线程的创建（简化代码）

        //new 接口/父类（）{  };
        //父类
       /*new Thread(){
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());//Thread-0
           }
       }.start();*/


        /*接口
        Runnable r=new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(r).start();//r可以看成他的实现类考虑多态


        //简化接口
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();*/

         //并发：交替执行
        // 并行：同时执行，速度快 效率高

        //线程安全
        //单线程是不会出现线程安全问题的
        ///多线程程序，没有访问共享数据时，不会产生问题
        //多线程访问共享数据，会产生线程安全问题
        //共享数据的一个案例1：生成一个实现类对象，通过这一个对象调用很多次start方法，就是开启很多线程共享一个资源


        //线程安全原理
        //开启多个线程，一起抢夺cpu的执行权，谁抢到谁执行
        //一旦碰到sleep（）就会放弃cpu的执行权，因为程序睡眠了一段时间
        //接着线程继续抢，都睡了之后，最早的睡的睡醒了继续执行。sleep()会产生错的结果。
        //线程安全问题是不能产生的，当一个线程在执行时，别的线程只能等待执行



        //解决线程安全问题
        //线程的同步技术

        //1 同步代码块：
       // synchronized (锁对象){
         //      具有线程安全问题的代码块
       // }
        //锁对象可以是任何对象。
        //该东西写在run方法里面
        //同步技术的原理：使用锁对象，叫对象监视器，三个线程一起抢，谁抢到谁执行
        //第一个抢到后，遇到同步代码块，他会看同步代码块是否有锁对象，有就会带走，进行到同步代码块里面去，执行里面的代码
        // 到第二个线程进去后，遇到同步代码块没有锁对象，就一直等待，等前面一个线程执行完归还锁对象
        //她才能继续执行同步代码块里面的东西，也就是说进去同步代码块里面的线程只能有一个，保证了安全，但是程序就会频繁的判断锁，归还锁，降低效率


        //2同步方法
        //1.把访问了共享数据的代码抽取出来放在一个方法中
        //2.加上synchronized修饰符
      /*  synchronized 返回值 变量名 (){
            共享数据的代码
        }
       */
        //原理也是锁对象，锁对象就是实现类对象，就是this当前对象
        //加上关键词static也是可以的
        //静态同步方法的对象不能是this，因为有静态还没this,是(实现类名称.class)





        //3Lock（接口）锁
        //比synchronized方法更加好一些
        //ReentrantLock是Lock的实现类
        //步骤1.创建实现类ReentrantLock对象
        //2.在产生线程安全的语句前使用lock()获取锁;
        //3然后释放锁unlock（）;

        /*检测买票的多线程安全问题
        sellticket sell = new sellticket();
        new Thread(sell).start();
        new Thread(sell).start();
        new Thread(sell).start();//开启三个线程//共享资源会出现重复的或者别的答案
       加上synchronized就不会产生安全问题 */





         //线程池--集合（LinkedList）用这个最好，
         //线程池的实现，JDK1.5之后就实现了//使用Executors类中的静态方法，staatic ExecutorService（接口） newThreadpool(int nthread)
         //参数是线程的数量,返回值是实现类对象，生产指定数量的线程池，创建一个类实现Runnable接口，重写run方法，设置线程任务，调用ExecutorService接口的submit
         //传递线程任务（实现类）开启线程，执行任务，销毁线程池是shutdown()
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new thread1());
        es.submit(new thread1());
        es.submit(new thread1());



    }

}
