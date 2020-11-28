package com.base;

import java.util.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class demo8 {
    public static void main(String[] args) {

        StringBuilder a=new StringBuilder("你大爷的");
        a.replace(1,3,"**");
        System.out.println(a);
        char[] chars="fee".toCharArray();
        System.out.println(chars[0]);
    }
}
