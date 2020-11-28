package com.base;
import java.io.*;
import java.util.*;

//稀疏数组
//java截图里面
public class spareArr {
    public static void main(String[] args) throws IOException {

        System.out.println("");
        int[][] chess=new int[11][11];
        int sum=0;
        chess[1][2]=1;
        chess[2][3]=2;
        chess[3][4]=9;
        for(int[] num:chess){
            for(int data:num){
                System.out.print(data+"\t");
            }
            System.out.println("");
        }
        for(int[] num:chess){
            for(int data:num){
                if(data!=0) sum++;
            }
        }
        System.out.println(sum);

        //二维数组转稀疏数组
        int k=1;
        int[][] spareArr=new int[sum+1][3];
        spareArr[0][0]=11;
        spareArr[0][1]=11;
        spareArr[0][2]=sum;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chess[i][j]!=0){
                    spareArr[k][0]=i;
                    spareArr[k][1]=j;
                    spareArr[k][2]=chess[i][j];
                    k++;
                }
            }
        }


        /*利用序列化流来实现更简单
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/4/src/b.txt"));
        os.writeObject(spareArr);
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/4/src/b.txt"));
        int[][] o = (int[][])is.readObject();
        for(int i=0;i<o.length;i++){
            for(int j=0;j<o[i].length;j++){
                System.out.print(o[i][j]+"\t");
            }
            System.out.println("");
        }*/


        /*将一个二维数组写到文件中中，存数字
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:/4/src/b.txt"));
        int[][] NewChess=new int[4][3];
        for(int[] num:spareArr){
            for(int data:num){
                bw.write(data+"\t");
            }
            bw.write("\r\n");
        }
        bw.close();
        String line;
        int len=0;
        int j=0;
        BufferedReader br = new BufferedReader(new FileReader("D:/4/src/b.txt"));

        //一次读一行，在从文件中的读取数字打出来。
        while((line=br.readLine())!=null){
            String[] split = line.split("\t");
            for(int i=0;i<split.length;i++){
                NewChess[j][i]=Integer.parseInt(split[i]);
            }
            j++;
        }
        for (int[] newChess : NewChess) {
            for (int i : newChess) {
                System.out.print(i+"\t");
            }
            System.out.println("");
        }*/


            //稀疏数组转二维数组

        int[][] chess2=new int[spareArr[0][0]][spareArr[0][1]];
        for(int i=1;i<spareArr.length;i++){
          chess2[spareArr[i][0]][spareArr[i][1]]=spareArr[i][2];
        }

        for(int[] num:chess2){
            for(int data:num){
                System.out.print(data+"\t");
            }
            System.out.println("");
        }

    }
}
/*
//原数组
0	0	0	0	0	0	0	0	0	0	0
0	0	1	0	0	0	0	0	0	0	0
0	0	0	2	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0

//稀疏数组
11	11	2
1	2	1
2	3	2


 */
