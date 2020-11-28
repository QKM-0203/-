package com.base;
import java.io.FileReader;

public class trycatch {
    public static void main(String[] args)  {
        try(FileReader  reader=new FileReader("D:/a.txt");){
            char c=(char) reader.read();//读文件里的一个字符
            char c1=(char)reader.read();//第二个字符
        }catch(Exception e){
            e.printStackTrace();
        }
        //jdk直接自动关闭资源，省去了finally，简便。
    }
}
