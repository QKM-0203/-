
package com.base;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
//SeverSocket这个类实现服务器套接字
public class Sever {
    public static void main(String[] args) throws IOException {
        ServerSocket sr = new ServerSocket(8888);
        Socket accept = sr.accept();
        InputStream is = accept.getInputStream();
        byte[] bytes=new byte[1024];
        int read = is.read(bytes);
        System.out.println(new String(bytes,0,read));
        //你好服务器
        OutputStream os = accept.getOutputStream();
        os.write("收到客户端".getBytes());
        sr.close();
        accept.close();
    }

}
