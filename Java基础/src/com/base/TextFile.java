package com.base;


import java.io.File;
import java.io.IOException;

public class TextFile {
    //打印整个D盘下1的所有目录利用递归
    public  static void printfile(File file,int level){
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        //为目录或者或者后缀名是.class才输出
        if(file.isDirectory()||file.getName().endsWith(".class"))
               System.out.println(file.getName());
        //如果file是目录，则获取子文件列表，并对每个子文件进行形同的操作
        if(file.isDirectory()){
            File[] file2=file.listFiles();//子文件存入数组
            for (File file1 : file2) {
                printfile(file1,level+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
       //获取项目的根目录
       // System.out.println(System.getProperty("user.dir"));
        File file = new File("D:/1");
        //file.createNewFile();//创建文件.txt
        //还有很多方法，可以通过点看见
        //File file1 = new File("D:/demo1/demo2");
       //file1.mkdirs();//创建目录，没有直接创建，但是file1.mkdir,没有不创建
        ///file1.delete();//是一层一层删，不是一次性删完，就是file1代表的是demo2
        //file.delete();//删除文件.txt
        printfile(file,0);
    }
}
