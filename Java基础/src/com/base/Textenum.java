package com.base;

public class Textenum {
    public static void main(String[] args) {
        //枚举的遍历
        for(week k:week.values()){
            System.out.println(k);
        }
        System.out.println(week.星期一);//使用枚举里面的一个元素
        System.out.println(week.values()[4]);//取枚举里面的第五个元素，下标从0开始
    }
}
enum week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期天
}
