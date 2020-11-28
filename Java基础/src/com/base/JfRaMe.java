package com.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//swing 组件中的窗体还有一个Jialog
class MyJDialog extends JDialog{
    public MyJDialog(){

    }
    public MyJDialog(JFrame f){
        //创建一个指定父窗口的对话框
        //继承用父类创建一个对话框
        //super(f,"这一个对话框窗体",false);//设置对话框的标题,false表示弹出对话框可以不关闭干别的事，但是true就只能关闭
        //super();
        //对话框才可以干别的事，强制性的
        //没有继承自己创建一个对话框。
        JDialog jDialog = new JDialog(f,"我是一个对话框",false);
        Container contentPane = jDialog.getContentPane();
        contentPane.add(new JLabel("这是一个对话框"));
        //contentPane.setLocation(400,100);
        contentPane.setBackground(Color.lightGray);
        jDialog.setBounds(120,120,300,300);//设置对话框的位置
        jDialog.setVisible(true);//设置对话框可见

    }
}
public class JfRaMe extends JFrame {

    public JfRaMe(){
        JFrame jf = new JFrame("这是父窗口");
        Container contentPane = jf.getContentPane();
        jf.setVisible(true);
        contentPane.setBackground(Color.pink);
        //contentPane.setLayout(null);
        jf.setLocation(400,100);
        jf.setSize(500,500);
        JButton jb = new JButton("弹出一个对话框");//设置一个按钮
        jb.setBounds(200,200,200,30);//设置按钮的在窗口的位置以及长和高
        contentPane.add(jb);
        contentPane.add(new JLabel("这是父窗口JFrame"));
        jb.addActionListener(new AbstractAction() {//点击该按钮 可以弹出对话框
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyJDialog(jf);//设置对话框可以显示出来
            }
        });
    }

    public static void main(String[] args) {
        new JfRaMe();
    }












    /*
    public static void ShowWindows(){
        JFrame jf = new JFrame("第一个窗口");//创建一个窗体，title为第一个窗口
        Container contentPane = jf.getContentPane();//将窗体转换为容器，可以在容器中添加组件或布局管理器，这个容器用来包含
        //和显示组件，如果需要将组件添加到容器中，可以使用下面的add方法。
        JLabel jl = new JLabel("什么都没有");//创建一个JLabel标签
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(jl);//将标签添加到容器中去
        contentPane.setBackground(Color.CYAN);//设置容器的背景颜色
        jf.setVisible(true);//窗体是否可见
        jf.setLocation(400,100);//窗体显示的位置向右为X，向下为Y
        jf.setSize(500,500);//窗体的大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗体的四种关闭方式，0，1，2，3数字代替

    }

    public static void main(String[] args) {
        ShowWindows();
    }*/

}