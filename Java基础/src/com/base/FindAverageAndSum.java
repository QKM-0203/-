package com.base;

import java.util.Scanner;

public class FindAverageAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split("\\s+");
        int average = 0;
        int sum = 0;
        for (int i = 1; i < s1.length; i=i+2) {
            sum += Integer.parseInt(s1[i]);
        }
        int people = s1.length/2;
        System.out.println(people);
        System.out.println("总分为："+sum);
        System.out.printf("平均分为：%.2f",sum/((people)*1.0));
    }
}
