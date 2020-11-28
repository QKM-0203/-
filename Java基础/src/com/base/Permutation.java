package com.base;

import java.util.Scanner;

//全排列
public class Permutation {
    public static void main(String[] args) {

        //将一个字符串中的字符转为数字，可以是负数，也可以是正数
        /*
        Scanner sc = new Scanner(System.in);
        StringBuffer sr=new StringBuffer(sc.next());
        System.out.println(sr.length());
        sr.replace(sr.length()-1,sr.length(),",");
        String NewStr = sr.substring(1, sr.length() - 1);
        String[] split = NewStr.split(",");
        int[] num1=new int[sr.length()-1];
        int i2=0;
        for (String s : split) {
            num1[i2++]=Integer.parseInt(s);
        }
        for (int i1 : num1) {
            System.out.print(i1+"\t");
        }*/
        Scanner sc = new Scanner(System.in);
        //将一个字符串中的字符转为数字，只能是正数。
        String s=sc.next();
        int[] number=new int[s.length()];
        int k=0,sum=0;
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(a<='9'&& a>='0') {
                while (a <= '9' && a >= '0') {
                    sum = sum * 10 + a - '0';
                    i++;
                    a = s.charAt(i);   //[1,2,3,4]
                }
                number[k++] = sum;
            }
            sum=0;
        }
    }
}
