package com.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//软件结构
//c/s结构，是指客户端和服务器的结构，常见程序有QQ,迅雷等软件
//B/S结构，是指浏览器和服务器结构，常见浏览器有谷歌，火狐等
//每个电脑都有一个IP地址，每个计算机都有一个唯一的IP地址，IP地址不能重复
//端口号，是一个逻辑端口，当我们使用网路软件，操作系统会随机的分配一个端口号给他，端口号
//由两个字节组成，取值在0-65535之间，
//注意：1024之前的端口号不能使用，已经被系统分配给已知的网络软件了
//网络软件的端口号不能重复，我们利用IP地址和端口号就可以保证信息准确无误的发送到对方
//客户端(Client) 服务器(Server)
/*Tcp通信（服务器和客户端）
//服务器的得先启动，客户端才能进行连接
客户端和服务器就会建立一个逻辑连接而这个连接包含一个对象，这个对象就是一个IO对象
客户端和服务器端就可以使用IO对象进行通信，通信的数据不仅仅是字符，所以IO对象是字节流对象
 表示客户端的类（Socket），服务器是一个配置高的电脑，他也有IP地址端口号，类ServerSocket，
 服务器和客户端进行交互，服务器必须明确和哪个客户端进行的交互，在服务器端有一个方法，叫accept，
 可以获取到请求客户端的对象。服务器是没有io流的，可以获取到客户端的对象Socket，用io流和客户端进行交互
 服务器使用客户端的字节输入流读取内容，在使用客户端的字节输出流来发送内容
 服务器使用客户端的流和客户端进行交互，套接字包含了IP地址和端口号
 构造方法Socket(String host,int port),host 服务器的地址，port 服务器的端口号
 当客户端和服务器进行交互，必须使用Socket中的提供的网络流，不能使用自己创建的流
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.85.1", 8888);
        OutputStream os = socket.getOutputStream();
        os.write("你好服务器".getBytes());
        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int read = is.read(bytes);
        System.out.println(new String(bytes,0,read));//收到客户端
        socket.close();

    }
}
