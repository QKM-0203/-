package com.id.itera;

import javax.swing.*;
import java.awt.*;

//按钮组
public class ButtonGroupDemo extends JFrame {
    public ButtonGroupDemo(String s){
        super(s);
        Container contentPane = getContentPane();
        setSize(300,300);
        JPanel jPanel = new JPanel();


        //单选按钮
        JRadioButton button = new JRadioButton("button");
        JRadioButton button1 = new JRadioButton("button1");
        JRadioButton button2= new JRadioButton("button2");



        //增加单选按钮
        jPanel.add(button);
        jPanel.add(button1);
        jPanel.add(button2);

        //按钮组，将多个单选按钮加入到按钮组里面，那这些按钮就不能多选了
        //如果不把这些按钮加入到一个按钮组里面那么他们可以进行多选的。
        /*ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button);
        buttonGroup.add(button1);
        buttonGroup.add(button2);*/


        contentPane.add(jPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ButtonGroupDemo("这是一个按钮组");
    }
}
