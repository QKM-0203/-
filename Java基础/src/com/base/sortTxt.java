package com.base;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
//对文件进行排序，利用map 集合的key自动排序
public class sortTxt {
    public static void main(String[] args) throws Exception {
        HashMap<String,String> map = new HashMap<>();
        BufferedReader bur = new BufferedReader(new FileReader("D:/4/src/b.txt"));
        BufferedWriter buw = new BufferedWriter(new FileWriter("D:/4/src/a.txt"));
         String s;
         String[] split=new String[10];
        while((s=bur.readLine())!=null){
             split = s.split("\\.");
             map.put(split[0],split[1]);
        }
        //map会按照key自动排序
        Set<String> strings = map.keySet();
        for (String string : strings) {
            buw.write(string+"."+map.get(string));
            buw.newLine();//换行符
        }
        bur.close();
        buw.close();

    }
}
