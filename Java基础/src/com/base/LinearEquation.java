package com.base;

import java.util.Scanner;

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    public LinearEquation(double a,double b,double c,double d,double e,double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }
    public boolean isSolvable(){
        if ((a*d)-(b*c) !=0){
            return true;
        }
        return false;
    }
    public double getX(){
        return (e*d-b*f)/(a*d-(b*c));
    }
    public double getY(){
        return (a*f-e*c)/(a*d-(b*c));
    }

    public static void main(String[] args) {
        System.out.println("请输入a b c d e f:");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();
        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
        if(linearEquation.isSolvable()){
            System.out.println("x is "+linearEquation.getX()+" and" +" y is " +linearEquation.getY());
        } else{
            System.out.println("The equation has no solution");
        }
    }
}
