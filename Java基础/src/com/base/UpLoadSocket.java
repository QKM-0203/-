package com.base;

import java.io.*;
import java.net.Socket;

//文件上传
//客户端将硬盘的文件上传到服务器，服务器将文件保存在硬盘
public class UpLoadSocket {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.85.1",8888);
        OutputStream os = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:/4/src/image/yyqx.jpg"));
        byte[] bytes=new byte[1024];
        int len =0;
        while((len=bis.read(bytes))!=-1){
            os.write(bytes);
        }


        //加一个终止符，不然服务器一直读不完
        socket.shutdownOutput();

        InputStream is =socket.getInputStream();
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        bis.close();
        socket.close();
        is.close();

    }
}
