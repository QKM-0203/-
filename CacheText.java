package com.java;
public class CacheText {
    public static void main(String[] args) {
        Cache hello = Cache.valueOf("hello");
        Cache hello1 = Cache.valueOf("hello");
        System.out.println(hello == hello1);
    }
}
