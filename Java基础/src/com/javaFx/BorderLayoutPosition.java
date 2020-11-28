package com.id.itera;

import sun.awt.windows.WingDings;

import javax.swing.*;
import java.awt.*;

//边界布局管理//分为5个区域北南西东中
public class BorderLayoutPosition extends JFrame {
    String[] border = {BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.WEST,
            BorderLayout.EAST};
    String[] borderName = {
            "center button","north button","south button","west button","east button"
    };
    public BorderLayoutPosition(String s){
        super(s);
        setSize(500,500);
        setLocation(300,300);
        setLayout(new BorderLayout());//设置为边界管理器
        Container contentPane = getContentPane();
        for (int  i = 0; i < border.length; i++){
            contentPane.add(new JButton(borderName[i]),border[i]);
        }
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutPosition("这是边界布局管理器");
    }
}
