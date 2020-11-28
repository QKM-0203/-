package com.id.itera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//复选框组件有一个图标是方块
//复选框可以进行多选继承AbstractButton类
public class JCheckBoxDemo extends JFrame {
     public JCheckBoxDemo(String title){
         super(title);
         setSize(300,300);
         setLayout(new BorderLayout());
         Container contentPane = getContentPane();
         JPanel jPanel = new JPanel();
         JTextArea jTextArea = new JTextArea(500, 500);
         JScrollPane jScrollPane = new JScrollPane(jTextArea);
         jPanel.add(jScrollPane);
         contentPane.add(jPanel,BorderLayout.NORTH);

         JPanel jPanel1 = new JPanel();
         JCheckBox jCheckBox = new JCheckBox("舞蹈");
         jPanel1.add(jCheckBox);
         jCheckBox.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextArea.append("你选中了舞蹈");
             }
         });

         JCheckBox jCheckBox1 = new JCheckBox("唱歌");
         jPanel1.add(jCheckBox1);
         jCheckBox.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextArea.append("你选中了唱歌");
             }
         });

         JCheckBox jCheckBox2 = new JCheckBox("rap");
         jPanel1.add(jCheckBox2);
         jCheckBox.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 jTextArea.append("你选中了rap");
             }
         });
         contentPane.add(jPanel1,BorderLayout.SOUTH);
         setVisible(true);
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     }

    public static void main(String[] args) {
        new JCheckBoxDemo("这是一个复选框");
    }
}
