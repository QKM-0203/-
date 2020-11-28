package com.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class EmpArraySort{

   /* @Override
    public boolean equals(Object obj) {
        demo2wei d=null;
        if(obj instanceof demo2wei){
           d=(demo2wei)obj;
        }
        return this.age==d.age;
    }*/


    public static void main(String[] args) {

        String str1="abc";
        //将String转换成StringBuilder(在字符串缓冲区，可变字符，不产生新的对象)
        StringBuilder stringBuilder = new StringBuilder(str1);
        //将StringBulider转换成String利用toString()方法
        String stu=stringBuilder.toString();
        String str2="abc"+"ABC";
        String s3="abc";//字符串重写了equals来比较内容，==是比较地址的，
        String st=str1+s3;
        System.out.println(st);
        System.out.println(str2==st);//编译器不知道里面存的什么，所以就是false
        String s=new String("abc");
        String s1=new String("abc");
        System.out.println(s.equals(s1));  //true
        System.out.println(Objects.equals(s,s1));//true
        System.out.println(s==s1);//false
      //二维数组
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[3][];
        //a[0] = new int[]{ 1,2,3,4};
        a[0]=new int[3];
        a[1]=new int[2];
        a[2]=new int[4];
    for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[i].length; i1++) {
                a[i][i1]=sc.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
                System.out.print(Arrays.toString(a[i]));
        }
        //[1, 2, 3][4, 5][6, 7, 8, 9]
        //使用二维数组存表格数据
        Object[] a1={1001,18,"起开梦","2002-02-03"};
        Object[] a2={1001,11,"申聪","2004-04-03"};
        Object[] a3={1001,12,"梦","2009-07-03"};
        Object[][] emp2=new Object[3][];
        emp2[0]=a1;
        emp2[1]=a2;
        emp2[2]=a3;
        //Arrays.sort(emp2);没办法排序，可以弄成一个类，来排序，里面的属性没办法获取
        for (int i =0; i < emp2.length; i++) {
                System.out.println(Arrays.toString(emp2[i]));


        }
        //[1001, 18, 起开梦, 2002-02-03]
        //[1001, 18, 申聪, 2004-04-03]
        //[1001, 18, 梦, 2009-07-03]
        emp1 Emp1 = new emp1(18,"qkm","2002-03-04",10);
        emp1 Emp2 = new emp1(19,"km","2004-08-04",11);
        emp1 Emp3 = new emp1(12,"qm","2003-06-04",15);
        //emp1[] emps=new emp1[3];
        emp1[] emps=new emp1[3];
        emps[0]=Emp1;
        emps[1]=Emp2;
        emps[2]=Emp3;
        //把数组转为字符串可以利用new String(数组名)，只能是char 或者 byte
        Arrays.sort(emps);//排序的底部是实现了Comparable接口，可以重写Comparable来进行某个东西的排序
        for (int i = 0; i < emps.length; i++) {
                  System.out.println(emps[i].toString());//重写了toString方法

        }

    }


}
class emp1 implements Comparable{
    public int age;
    public String name;
    public String year;
    public int bd;

    @Override
    public String toString() {
        return "emp1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", bd=" + bd +
                '}';
    }

    public emp1() {
    }

    public emp1(int age, String name, String year, int bd) {
        this.age = age;
        this.name = name;
        this.year = year;
        this.bd = bd;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getBd() {
        return bd;
    }

    @Override
    public int compareTo(Object o) {
        emp1 emp3=null;
        if(o instanceof emp1){
            emp3=(emp1) o;
        }
        if(emp3.age>this.age){
            return -1;
        }
        else if(emp3.age<this.age) return 1;
        else return 0;
    }
}
