package com.base;
import java.util.Scanner;

public class Main {
    public static String convertMillis(long millis){
        long hour=millis/3600000;

        long minute=millis%3600000/60000;

        long second=millis%3600000%60000/1000;
        return hour+":"+minute+":"+second;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        long milliseconds=scanner.nextLong();
        System.out.println(Main.convertMillis(milliseconds));
        int[] s;
    }
}
