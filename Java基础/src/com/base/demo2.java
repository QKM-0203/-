package com.base;
public class demo2{
    private static demo2 Demo2=null;
    public void fun(){
        System.out.println("hello");
    }
    private demo2(){

    }
    public static demo2 getobject(){
        if(Demo2==null){
            Demo2= new demo2 ();
        }
        return Demo2;
    }
}
