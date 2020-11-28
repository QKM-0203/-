package com.id.itera;

import javax.swing.*;
import java.awt.*;

//单选按钮组件有一个图标是圆圈
public class JRadioButtonDemo extends JFrame {
    public JRadioButtonDemo(String s){
        super(s);
        setLayout(new FlowLayout(0,10,10));
        Container contentPane = getContentPane();
        //也可以设置图标，同时还有一个属性是是否开始的时候被选中。
        JRadioButton button = new JRadioButton("button");
        contentPane.add(button);
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JRadioButtonDemo("单选按钮");
    }
}
