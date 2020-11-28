package com.base;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  num = scanner.nextInt();
        int[] num1 = new int[1000000];
        for (int i = 0; i < num; i++) {
            num1[scanner.nextInt()]++;
        }
        Arrays.sort(num1);
        for(int i = 0;i < num1.length;i++){
            if(num1[i]!=0){
                System.out.println(num1[i]);
            }
        }
    }
}
