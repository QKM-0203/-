package com.base;

import java.util.Scanner;

public class Hanoi {
    private static void move(char start,char end){
        System.out.printf("%c -> %c\n",start,end);
    }
    private static void hanoi(int n,char a,char b,char c){
        if(n==1) System.out.printf("%c - >%c\n",a,c);
        else{
            hanoi(n-1,a,c,b);
            move(a,c);
            hanoi(n-1,b,a,c);
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入汉诺塔牌的总数:");
        Scanner scanner = new Scanner(System.in);
        int hanoisum=scanner.nextInt();
        hanoi(hanoisum,'a','b','c');
    }
}
