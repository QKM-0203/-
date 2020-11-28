package com.base;


import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;//日期类
import java.util.Date;//日期类
import java.util.Scanner;

import static java.util.Calendar.YEAR;

public class demo1 {
        public static void main(String[] args)  {

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(new Date().getTime());//毫秒值
            //String s=sdf.format(new Date());
          //  System.out.println(sdf.parse(s));
            /*计算一个人出生了多少天
            Scanner sc=new Scanner(System.in);
            String brithday=sc.next();
            Date birthdayparse = sdf.parse(brithday);
            long birthdayparseTime = birthdayparse.getTime();
            long todaytime=new Date().getTime();
            System.out.println((todaytime-birthdayparseTime)/1000/60/60/24);

            */
            //Calendar是一个抽象类里面有一个静态的方法getInstance返回子类的对象

            Calendar c =Calendar.getInstance();//多态
            System.out.println(c.getTime().getTime());//毫秒值
            //System.out.println(sdf.format(c.getTime()));//Date类中的getTime是转换成毫秒值，
            // 而calendar类中的getTime是获取当前时间;
            //get方法用来获取年月日的
            System.out.println(c.get(Calendar.MONTH)+1);//返回的是西方的月份0-11.东方的的月份加一就可以
            System.out.println(c.get(Calendar.YEAR));
            System.out.println(c.get(Calendar.DATE));
            //c.set(2010,3,4);
            //系统类System
            System.currentTimeMillis();//获取系统当前时间转换成毫秒值
            //Runtime.getRuntime().FreeMemory();//获取系统剩余的的内存空间
            //上面两个可以用来检测运行程序所耗得时间以及空间。及将程序运行开始前后的时间和空间一获取，然后相减即可。
            //复制数组内容
            int[] src={1,2,3,4,5};
            int[] dest={6,7,8,9,10};
            System.arraycopy(src,0,dest,0,3);
            System.out.println(Arrays.toString(dest));
            //StringBuilder底层也是和String一样是一个数组，区别是String数组是final修饰，而stringBuilding没有
            //被修饰，
            //在字符串缓冲区，提高操作效率，节省内存，初始有16个字符，超过就会自动扩充为原来的2倍

            //String s1="a"+"b"+"c";//会产生5个数组；
            //而StringBuilder 只产生一个数组
            StringBuilder bu = new StringBuilder("234");//添加字符串
            System.out.println(bu.indexOf("234"));
            //String s2 = bu.toString();//把StringBuilder转换成string类型
            StringBuilder bu1 = bu.append("abc");
            System.out.println(bu1);
           // System.out.println(bu==bu1);
           // String string = new String("234");
           // System.out.println(string);


        }
    }

