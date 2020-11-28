package com.id.itera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//按钮
//按钮的这些操作来自于父类AbstractButton
public class JButtonDemo extends JFrame{
    public JButtonDemo(String s){
        super(s);
        Container contentPane = getContentPane();
        setLayout(new GridLayout(1,5,10,10));
        //获取图片
        Icon icon = new ImageIcon("src/com/yyqx.jpg");
        for (int i = 0; i < 5; i++){
            JButton jb = new JButton("button",icon);
            if (i == 0) jb.setEnabled(false);//设置一些按钮不可用
            jb.setBorderPainted(false);
            //该按钮有文字还有图片
            contentPane.add(jb);

        }
        JButton jButton = new JButton();
        jButton.setIcon(icon);//为该按钮设置图片
        //监听事件弹出对话框
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"弹出对话框");
            }
        });
        contentPane.add(jButton);
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JButtonDemo("按钮操作");
    }
}
