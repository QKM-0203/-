package com.base;

import java.util.ArrayList;
//jdk1.5+自动装箱，拆箱
public class demo9 {

    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();
        System.out.println(list);// 打印出集合内容，没有则打印[];//[]
        //list.add("a");
        list.add(new Integer(9));//添加元素返回值为Boolean判断添加是否成功
        list.add(new Integer(10));
        list.get(1);//从集合中获取元素；1为下标
        System.out.println(list.get(0));
        for(Object obj:list) {
            Integer s = (Integer) obj;
            System.out.println(s);
        }
        System.out.println(list);//[9, 10]集合内容用逗号分开
        System.out.println(list.size());//集合大小；
    }



}
