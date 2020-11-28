package com.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 飞机游戏窗口
 * @author 戚凯萌
 *
 */

public class MyGameFrame extends JFrame {
    Image timg=GameUtil.getImage("image/timg.jpg");
    /**
     * 初始化窗口
     */
    public void launchFrame() {
        this.setTitle("起开梦__作品");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(300, 250);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(timg,250,250,null);
    }

    public static void main(String[] args) {
        MyGameFrame myGameFrame = new MyGameFrame();
        myGameFrame.launchFrame();
    }

}
