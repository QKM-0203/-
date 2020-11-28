package com.base;
import java.util.Arrays;
import java.util.Scanner;

public class SortString {
    public static String str;
    public static void sortString(String s){
        str = s;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        sortString(s);
    }
}
