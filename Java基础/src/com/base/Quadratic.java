package com.base;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Quadratic {
    private double a;
    private double b;
    private double c;

    public Quadratic(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }
    public  double getDiscriminant(){
        return (b*b)-(4*a*c);
    }
    public double getRoot1(){
        if (getDiscriminant() >=0) {
            return (b*(-1)+Math.sqrt(getDiscriminant()))/(2*a);
        } else{
            return 0;
        }
    }
    public double getRoot2(){
        if (getDiscriminant() >=0) {
            return (b*(-1)-Math.sqrt(getDiscriminant()))/(2*a);
        } else{
            return 0;
        }
    }

    public static void main(String[] args) {
        DecimalFormat d = new DecimalFormat("#.#####");
        System.out.println("请输入a b c:");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        Quadratic quadratic = new Quadratic(a,b,c);
        if (quadratic.getDiscriminant() < 0) {
            System.out.println("The equation has no real roots");
        } else if (quadratic.getDiscriminant() == 0){
            System.out.println("The equation has one root " +quadratic.getRoot1());
        } else{
            System.out.println("The equation has two roots " +d.format(quadratic.getRoot1())+ " and " +d.format(quadratic.getRoot2()));
        }

    }
}
