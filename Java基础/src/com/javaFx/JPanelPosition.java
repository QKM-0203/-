package com.id.itera;

import javax.swing.*;
import java.awt.*;
//常用面板
public class JPanelPosition extends JFrame {
    public JPanelPosition(String s){
        super(s);
        setLayout(new GridLayout(2,5,10,10));//设置整个网格为2行2列
        Container contentPane = getContentPane();
        JPanel p1 = new JPanel(new GridLayout(1,2,10,10));//设置每一个面板的行和列
        JPanel p2 = new JPanel(new GridLayout(2,2,10,10));
        JPanel p3 = new JPanel(new GridLayout(3,4,10,10));
        JPanel p4 = new JPanel(new GridLayout(2,2,10,10));
        p1.add(new JButton("button1"));
        p1.add(new JButton("button1"));
        p2.add(new JButton("button2"));
        p2.add(new JButton("button2"));
        p2.add(new JButton("button2"));
        p3.add(new JButton("button3"));
        p3.add(new JButton("button3"));
        p3.add(new JButton("button3"));
        p3.add(new JButton("button4"));
        p3.add(new JButton("button4"));
        p3.add(new JButton("button4"));
        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelPosition("这是一个面板");
    }
}
