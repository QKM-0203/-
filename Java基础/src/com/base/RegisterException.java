package com.base;

import java.io.Serializable;
import java.util.Scanner;

//自定义异常类
//必须继承Exception或者RuntimeException
/*
public class RegisterException extends RuntimeException{
    public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);//让父类处理这个异常
    }
}
class demo1Register{
    static String[] username={"戚凯萌","申聪","王苗"};
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String name=sc.next();
        checkname(name);
    }

    private static void checkname(String name){
        for (String s : username) {
            if(s.equals(name))
                    throw new RegisterException("亲，该用户名已被注册过");//当继承RuntimeException时不用try catch而用throws
            //不用写throws因为runtime就是抛给虚拟机，虚拟机会处理。
            //但是继承Expectation时用throws就得一直抛抛出这个方法，在抛出类都要写




            申聪
             Exception in thread "main" com.fly.game.RegisterException: 亲，该用户名已被注册过
	         at com.fly.game.demo1RegisterExpection.checkname(RegisterException.java:28)
	         at com.fly.game.demo1RegisterExpection.main(RegisterException.java:22)

        }
        System.out.println("恭喜您！注册成功！");
    }
}
*/


public class RegisterException extends Exception{
    public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);//让父类处理这个异常
    }
}
class demo1Register{
    static String[] username={"戚凯萌","申聪","王苗"};
    public static void main(String[] args) throws RegisterException {
        Scanner sc = new Scanner(System.in);
        String name=sc.next();
        checkname(name);
    }

    private static void checkname(String name) throws RegisterException {
        for (String s : username) {
            if(s.equals(name))

                throw new RegisterException("亲，该用户名已被注册过");//当继承RuntimeException时不用try catch而用throws
            //不用写throws因为runtime就是抛给虚拟机，虚拟机会处理。在上面
            //但是继承Expectation时用throws就得一直抛抛出这个方法，在抛出类都要写

            //当利用try catch时在catch部分应写一个return，这样该方法就不会执行了，不然会出现结果不对
            /*
            申聪
             Exception in thread "main" com.fly.game.RegisterException: 亲，该用户名已被注册过
	         at com.fly.game.demo1RegisterExpection.checkname(RegisterException.java:28)
	         at com.fly.game.demo1RegisterExpection.main(RegisterException.java:22)
             */
        }
        System.out.println("恭喜您！注册成功！");
    }
}