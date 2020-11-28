package com;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
//icon是一个接口ImageIcon是他的实现类 是给标签设置图标或者图片
public class JavaFx extends JFrame implements Icon{
    private int width;
    private int height;
    ImageIcon image;
    public JavaFx(){

    }
    public JavaFx(String s,JavaFx javaFx) throws IOException {
        super(s);
        setVisible(true);
        setLocation(400,100);
        //setLayout(null);
        setSize(1000,1000);
        Container contentPane = getContentPane();
        JButton jButton = new JButton("易烊千玺");
        jButton.setBounds(150,150,100,50);
        contentPane.add(jButton);
        //image = new ImageIcon("src/com/yyqx.jpg");
       // URL url = JavaFx.class.getResource("src/com/yyqx.jpg");
        Icon imageIcon = new ImageIcon("src/com/yyqx.jpg");
        JLabel j = new JLabel("ok",imageIcon,SwingConstants.CENTER);
        //j.setIcon(imageIcon);//设置图标
        j.setHorizontalAlignment(SwingConstants.CENTER);//文字居中
        j.setOpaque(true);//设置标签为不透明状态
        contentPane.add(j);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public  JavaFx(int width,int height){
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) throws IOException {
        JavaFx javaFx = new JavaFx(15,15);
        new JavaFx("随便吧",javaFx);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
