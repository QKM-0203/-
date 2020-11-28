package com.base;
public class demo17 extends demo18 {
    //public abstract void method();//子类实现该方法的快捷键Alt加回车
    public static void main(String[] args) {


        // text.special();//父类没有，编译看左边，运行看右边
        demo18 de=new demo17();//（抽象父类指向正常子类的空间可以）编译看左边，运行看右边
        de.work();
    }

    @Override
    public void work() {
        System.out.println("重写抽象方法");
    }
}