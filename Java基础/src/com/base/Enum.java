package com.base;
//枚举里面的是一个静态的常量并且是一个实例。

//方法1
public class Enum {
    enum Constant {
        Con1,//是一个实例调用了构造方法
        Con2;//同上
        private String s = null;
        private Constant(){

         }
        private Constant(String s) {
            this.s = s;
        }

        private String Show() {
            return s;
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < Constant.values().length; i++){
            System.out.println(Constant.values()[i]);
        }
    }
}


/*方法2
interface d{
    public String show();
}
public enum Constant implements d{
    con{
        @Override
        public String show() {
            return ("con");
        }
    },
    cons1{
        public  String show(){
            return ("cons1");
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < Constant.values().length; i++){
            System.out.println(Constant.values()[i].show());
        }
    }
}*/