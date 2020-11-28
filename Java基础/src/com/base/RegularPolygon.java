package com.base;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RegularPolygon extends shape {
    private int n;
    private double side;
    public RegularPolygon(int n,double side){
        this.n = n;
        this.side = side;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1","2");
        System.out.println(
        stringStringHashMap.get("1"));
    }
}
abstract class shape {// 抽象类

    /* 抽象方法 求面积 */
    public abstract double getArea();

    /* 抽象方法 求周长 */
    public abstract double getPerimeter();
}
