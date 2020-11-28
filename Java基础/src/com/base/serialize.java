package com.base;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

//序列化流(Serialize)
//把对象以流的方式写入到文件中去，叫写对象，将对象的序列化
//读取文件中保存的对象，以流的方式，叫做读对象，也叫做对象的反序列化
//因为对象包含不仅仅是字符还有字节，所以使用字节流
//注意：序列化时或抛出异常如果没实现Serializable,所以哪个类要序列就得的实现该接口，给类一个标记，再让该类序列化的时候，就会检查，是否可以序列化
public class serialize {
   //序列化流的应用
    public static void main(String[] args) throws Exception {
        /*int[][] chess=new int[11][11];
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
        }
        //System.out.println(Arrays.toString(o));*/
        //序列化流
        ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("D://4//src//b.txt"));
        ops.writeObject(new student(18, "戚凯萌"));



        //反序列化流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://4//src//b.txt"));
        Object o = ois.readObject();
        ois.close();
        ops.close();
        System.out.println(o.toString());
        //加一个序列的序号,因为序列化的时候会产生一个序号，但当你修改类时，序列号就会改变，在你反序列化的时候就会抛出异常，所以加
        //一个序列号让他不生成新得序列号就可以// private static final long serialVersionUID=1L;

        //关键字
        //transient加上之后，就不能被序列化了//student{age=18, name='null'}
        //static关键字不能被序列化，因为序列化的都是对象，而static属于类，不属于对象，他就不能被序列化。

       //当想要把多个对象存到文件中，可以创建一个集合，对集合进行序列化反序列化，把集合搞进去
        /*ArrayList<student> students = new ArrayList<>();
        students.add(new student(19,"申聪"));
        students.add(new student(19,"李艳"));
        ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("D://4//src//b.txt"));
        obs.writeObject(students);
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("D://4//src//b.txt"));
        Object o1 = ois1.readObject();
        ArrayList<student> list=(ArrayList<student>)o1;
        for (student student : list) {
            System.out.println(student);
        }
        ois1.close();
        obs.close();*/



        //打印流(PrintStream extends outputStream),只负责对输出数据操作，不会抛出异常
       /* PrintStream ps = new PrintStream("D://4//src//b.txt");
       // ps.write(97);//父类的方法，会查询编码表//a
        ps.print("hello");//特有的方法，写什莫就是神魔//97//带换行方法
        ps.close();*/



        //改变输出语句的的目的地
       /* PrintStream ps = new PrintStream("D://4//src//b.txt");
        System.setOut(ps);
        System.out.println("我在b.txt文件中输出");//该语句没有在控制台输出，在b.txt文件中输出（既就是打印流确定的文件）
        ps.close();
        */
        
    }

}

