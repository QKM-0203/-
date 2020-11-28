package com.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UpLoadServe{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        java.lang.String filename=System.currentTimeMillis()+".jpg";
        BufferedOutputStream bup = new BufferedOutputStream(new FileOutputStream("D:/4/out/"+filename));
        //让服务器处于监听状态，一直有客户端上传图片，则服务器就不用关闭了
        while(true) {
            Socket accept = serverSocket.accept();
            //多线程提高效率
            new Thread(new Runnable(){
                @Override
                public void run() {
                    byte[] bytes = new byte[1024];
                    try{
                        InputStream is = accept.getInputStream();
                        int read = 0;
                        while ((read = is.read(bytes)) != -1) {
                            bup.write(bytes);
                        }

                        OutputStream os = accept.getOutputStream();
                        os.write("正在上传...............".getBytes());
                        os.write("上传成功".getBytes());

                    }catch(IOException e){
                        System.out.println(e);
                    }finally {
                        try {
                            bup.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            accept.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();

        }
        //serverSocket.close();

    }
}
