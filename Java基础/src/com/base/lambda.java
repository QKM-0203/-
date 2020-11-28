package com.base;
//函数式编程
//简便代码

import java.util.Arrays;
import java.util.Comparator;

public class lambda {
    public static void main(String[] args) {

        //使用匿名内部类实现多线程
        /*new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();*/

        /*使用lambda表达式进行写
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
        }
        ).start();*/
      //lambda的标准格式，由三部分组成，一些参数，一个箭头，一段代码（参数列表）->重写的代码
     /* ():接口中抽象方法的参数，没有就空着，有就写着，用逗号分开，
        ->传递的意思，把参数传递给方法体
        {}：重写接口里面的抽象方法的方法体*/



        /*例子
        creatcook(new lambdmtext() {
            @Override
            public void cook() {
                System.out.println("吃饭了");
            }
        });*///吃饭了




        /*使用lambda无参用法
        creatcook(()->{
                System.out.println("吃饭了");

        });//吃饭了*/




        //使用lambda有参用法
       student[] students={
                new student(19, "戚凯萌"),
                new student(19, "戚凯萌"),
                new student(18, "申聪"),
            };
        Arrays.sort(students, (student o1, student o2)->{
               return o1.age-o2.age;
        });/*
        student{age=18, name='申聪'}
        student{age=19, name='戚凯萌'}
        student{age=19, name='戚凯萌'}*/

        for (student stu : students) {
            System.out.println(stu.toString());
        }
        //lambda表达式使用前提，
        //1必须有接口，且要求接口中有且只有一个抽象方法，


    }
    /*
    public static void creatcook(lambdmtext lam){
        lam.cook();

    }*/
}
