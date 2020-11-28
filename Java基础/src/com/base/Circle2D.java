package com.base;

import java.util.Scanner;

public class Circle2D {
    private double x = 0;
    private double y = 0;
    private double r = 1;
    public Circle2D(double x,double y,double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public double getArea(){
        return 3.14*r*r;
    }
    public double getPerimeter(){
        return 2*3.14*r;
    }
    public boolean isContainsPoint(double a,double b){
        if ((x-a)*(x-a)+(y-b)*(y-b)<r*r) {
            return true;
        }
        return false;
    }
    public boolean isContainsCircle(Circle2D circle2D){
        if (Math.sqrt((circle2D.x-x)*(circle2D.x-x)+(circle2D.y-y)*(circle2D.y-y)) < Math.abs(circle2D.r-r)){
            return  true;
        }
        return false;
    }
    public boolean OverLaps(Circle2D circle2D){
        if (Math.sqrt((circle2D.x-x)*(circle2D.x-x)+(circle2D.y-y)*(circle2D.y-y)) < Math.abs(circle2D.r+r)){
            return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        Circle2D circle2D = new Circle2D(2, 2, 5);
        System.out.println("该圆面积为："+circle2D.getArea());
        System.out.printf("该圆周长为：%.2f\n",circle2D.getPerimeter());
        System.out.println("该圆是否是否包含(3,3)："+circle2D.isContainsPoint(3,3));
        System.out.println("该圆和（4,5,10.5)是否是包含关系："+circle2D.isContainsCircle(new Circle2D(4,5,10.5)));
        System.out.println("该圆是否和（3,5,2,3)是否是相交关系："+circle2D.OverLaps(new Circle2D(3,5,2.3)));
    }
}
