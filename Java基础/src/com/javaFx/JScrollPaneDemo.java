package com.id.itera;

import javax.swing.*;
import java.awt.*;

//JScrollPane带滚动条的面板，窗体太小显示不了较大的内容，可以使用该面板
//但是该面板只能加入一个组件，若有多个组件，可以将多个组件放在JPanel面板里面，再放入到
//该面板里面
public class JScrollPaneDemo extends JFrame {
    public JScrollPaneDemo(String s){
        super(s);
        setSize(300,300);
        setLocation(300,300);
        Container contentPane = getContentPane();

        //JPanel jPanel = new JPanel(new GridLayout(1,2,10,10));
        //jPanel.add(new JButton("button1"));
        //jPanel.add(new JButton("button2"));
        //创建文本区域组件,并且设置大小
        JTextArea jTextArea = new JTextArea(500,500);
        //创建JScrollPane面板对象，将太大的东西放到这个面板里面，然后加入到容器里面
        JScrollPane jScrollPaneDemo = new JScrollPane(jTextArea);
        contentPane.add(jScrollPaneDemo);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollPaneDemo("这是一个带滚动条的面板");
    }
}
