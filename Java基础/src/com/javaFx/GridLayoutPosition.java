package com.id.itera;

import javax.swing.*;
import java.awt.*;

//网格布局管理器
//网格构造方法
/*
GridLayout(int rows,int columns){//设置行和列
}
GriLayout(int rows,int columns,int horizGap,int vertGap)
//设置行和列和水平距离和垂直距离
 */
public class GridLayoutPosition extends JFrame {
    public GridLayoutPosition(String s){
        super(s);
        Container contentPane = getContentPane();
        setLayout(new GridLayout(5,5,5,5));
        setLocation(300,300);
        for (int i = 0; i < 20; i++) {
            contentPane.add(new JButton("button"+i));
        }
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GridLayoutPosition("这是网格布局管理利器");
    }
}
