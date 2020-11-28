package com.base;
//接口中只能定义静态常量和抽象方法且接口不能创建对象
//jdk1.8以上版本可以使用default 和 static
public interface demo3 {
    public int i=1;
    public static final int num=10;
    public void interfaces();
    //通过接口来调用静态方法（）
    public static  void staticinterface(){
        System.out.println("static接口方法");
    }
    //（默认方法）因为接口不能创建对象，所以通过实现接口的类创建对象调用（就是通过实现类所创建的对象直接调用该接口中定义的默认方法）
    public  default  void defaultinterface(){
        System.out.println("default接口方法");
    }
    //私有方法(用于在本接口中要重复使用的地方，写成private只可在本接口使用，实现类也不可使用)
    //1.静态私有 private static void method
    //2普通私有 private void method
    //静态常量 public static final int num=10(必须复制且不能改值)
}