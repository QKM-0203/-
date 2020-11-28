package com.base;

import java.util.Arrays;
import java.util.HashSet;

public class Kmp {
    /*暴力枚举
    public static void main(String[] args) {
       String s="尚硅谷 硅谷尚硅谷 硅谷硅谷";
       String s1="硅谷尚硅谷";
        char[] chars = s.toCharArray();
        char[] chars1 = s1.toCharArray();
        int CharsLen=chars.length;
        int CharLen1=chars1.length;
        int i=0,j=0;
        while(i<CharsLen && j<CharLen1){
            if(chars[i]==chars1[j]){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        if(j==CharLen1) System.out.println("true"+(i-j));
        else System.out.println("false");

    }*/
    //kmp
    //先求部分匹配表，
    /*创建一个next数组的保存部分匹配值
    首先第一个元素的值肯定是零next[0]=0;
     */
    public static void main(String[] args) {
        System.out.println(Character.isDigit('a'));
        String s="BBC ABCDAD ABCDABCDABDE";
        String s1="abcab";
        int[] next=new int[s1.length()];
        next[0]=0;
        for(int i=1,j=0;i<s1.length();i++){
            while(j>0 && s1.charAt(i)!=s1.charAt(j)){
                j=next[j-1];
            }
            if(s1.charAt(i)==s1.charAt(j)){
                j++;
            }

            next[i]=j;
        }
        System.out.println(Arrays.toString(next));
        System.out.println(KmpNext(s,s1,next));
    }
    public static int  KmpNext(String str1,String str2,int[] next){
        for(int i=0,j=0;i<str1.length();i++){
            while((str1.charAt(i)!=str2.charAt(j)) && j>0 ){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }


}
