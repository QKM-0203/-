package com.id.itera;

import javax.swing.*;
import java.awt.*;

//setLayout(null) 表示该容器不再使用布局管理器
//使用绝对布局setBound();
// 流布局管理器(FlowLayout类)
public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition(String title){
        super(title);
        Container contentPane = getContentPane();
        //1 代表中间对齐，2代表靠右对齐，0代表靠左对齐，第一个为水平间距 ，第二个为垂直间据
        setLayout(new FlowLayout(1,10,10));
        for (int i = 0; i < 10; i++){
            contentPane.add(new JButton("button"+ i));
        }
        setSize(200,300);
        setLocation(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition("这是流布局管理器");
    }
}
