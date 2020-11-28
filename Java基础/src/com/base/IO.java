package com.base;


import java.io.BufferedReader;
import java.io.FileReader;

//OutputStream是一个抽象类（所有字节输出流的父类）
//有很多子类其中一个FileOutputStream,文件字节输出流（把内存的数据写入磁盘中）（给文件里面写）
//InputStream（）也是一个抽象类
//文件输入流（FileInputStream）从硬盘中读入内存中(读文件)
public class IO {
    public static void main(String[] args) throws Exception {
        //使用流会占用资源，用完后要关。
       // byte[] bytes1 = "你好吗".getBytes();//把字符串转换为字节存入数组中去



        //写入多个字节
        // byte[] bytes={-98,-66,-67,-68};//如果是正数在ASCall表里面插，负数在GBK系统默认里面查好像就是中文
        //fos.write(bytes);


        // 程序执行一次，每次会创建新的文件覆盖源文件，不是在源文件后面直接写的
        /*FileOutputStream fos = new FileOutputStream("D:/1/a.txt");
        fos.write(97);
        fos.write(bytes1);
        fos.close();
*/
        //写true不覆盖源文件，直接在源文件后面写数据,相当于执行一次程序，写一次，
        //写false创建新文件，覆盖原文件，只写入一次。
       // FileOutputStream fos1 = new FileOutputStream("D:/4/src/b.txt", false);
        //fos1.write(bytes1);

        //写入的东西换行(换行符)
        //windows: \r\n
        //linux :/n
        //mac:/r
       /*for (int i = 0; i < 10; i++) {
            fos1.write("你好".getBytes());
            fos1.write("\r\n".getBytes());//写一次换一次行
        }
        fos1.close();*/



       // FileInputStream fis = new FileInputStream("D:/4/src/b.txt");
        //System.out.println(fis.read());

        //read()读取一个字节时返回的是该字节的ASCALL编码，都多个字节时返回读取的的字节个数
        //fis.read()当读到没数据的时候返回-1;
        //读取多个字节，定义一个数组来存
        /*byte[] bytes=new byte[10];
        //fis.read(bytes)文件中内容为2456结果为3前面还读了一个
        int len=0;
        while((len=fis.read(bytes))!=-1) {//只要数组有空间并且文件没读完就一读，最后出来
            System.out.println(len);
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();*/


        //文件的复制
        /*FileInputStream fis1 = new FileInputStream("D:\\4\\src\\image\\timg.jpg");
        FileOutputStream fos1 = new FileOutputStream("D:\\1\\src\\timg.jpg");//将上面的图片复制到地下来
        int len1=0;
        byte[] bytes2 = new byte[1024];
        while((len1=fis1.read(bytes2))!=-1){//一次读多个文件提升效率
            fos1.write(bytes2,0,len1);//一次写入1个数组，从0开始，写len1个
        }
        fos1.close();
        fis1.close();

        */
        //使用字节流读取中文时，不能读出正确的中文，所以产生了字符流
        //字符流
        //Reader,是一个抽象类，FileReader extends InputStreamReader extends Reader
         //FileReader 文件字符输入流



       // FileReader fr = new FileReader("D:/4/src/b.txt");
       /* int len2=0;
        while((len2=fr.read())!=-1){
            System.out.print((char)len2);//一次读一个
        }*/
       /* char[] chars = new char[1024];
        int len2=0;
        while((len2=fr.read(chars))!=-1){
            System.out.println(new String(chars,0,len2));//读到字符数组里面去
        }
       fr.close();*/

        //字符输出流（Write），顶层超类，抽象类，子类FileWrite(文件字符输出流)
        //注意字符输出流再给文件里面写东西实际上是给内存缓冲区写，是一个字符转为字节的过程，使用flush方法会把
        //内存缓冲区的数据刷新到文件中去，最后close()方法也可以将数据缓冲区去，所以flush方法可以不调用。但要close
        //FileWriter fw = new FileWriter("D://4//src//b.txt");
        //fw.write(97);//写单个
       // fw.write(chars);//写字符数组
        //fw.write(chars,0,len);//写字符数组的一部分，从0开始，写len个
        //fw.write("戚凯萌",0,2);//从0开始，写2个戚凯
        //追加写和换行 和上面的字节流一样
       // fw.close();



        //缓冲流
        //增加一个缓冲区实质是一个数组，,提高效率，读到数组里面去，返回整个数组
        //字节缓冲输出流BufferedOutputStream
       /*  FileOutputStream foss=new FileOutputStream("D:/1/a.txt");
        BufferedOutputStream  bufo = new BufferedOutputStream(foss);
        bufo.write(1);
        foss.flush();
        foss.close();*/

        //字符缓冲输入流BufferedReader和上面差不多

        BufferedReader bofw = new BufferedReader(new FileReader("D:/4/src/b.txt"));
        String s;
        while((s = bofw.readLine())!=null)//一次读一行,读到末尾有个标记是null。
              System.out.println(s);

       //字符编码
        //ASCII编码表 包括
        //ISO-8859-1 单字节编码（欧洲）
        //21003个汉字 GBK(中文编码)两个字节 70244 GB18030(中文编码表，支持日韩还有少数民族的繁体)
        //Unicode(世界统一标准国际化) Utf-8一个中文 3个字节




        //转换流Idea默认的编码方式是UTF-8;转换流的作用就是可以写文件以指定的文件编码格式
        //不同的编码转换
        //因为FileRead和FileWrite都会查询idea的指定编码表，所以是根据idea来的，底下是根据情况定的
        //InputStreamReader查询指定的编码表，然后将字节转换为字符，不会产生乱码
        //OutputStreamWriter 作用同上 把字符转为字节

        /*OutputStreamWriter ouw = new OutputStreamWriter(new FileOutputStream("D:/4/src/b.txt"));
       //后面的参数是以指定的文件编码格式写进去。，不写就是默认的UTF-8
        ouw.write("你好");
        ouw.close();
        */



        /*InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/4/src/b.txt"));
        //默认UTF-8读，后面的参数和文件的类型编码要一致
        int len=0;
        while((len=isr.read())!=-1){
            System.out.println((char)len);
        }
        isr.close();
        */

    }
}
