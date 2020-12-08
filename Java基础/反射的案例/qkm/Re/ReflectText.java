package cn.qkm.Re;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//写一个框架，体现反射的功能，实现可以产生任意的类的对象，和让任意类的对象的方法执行
public class ReflectText {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties properties = new Properties();
        //获取类加载器（默认为应用程序类加载器，加载的是用户自己写的类的class文件，
        ClassLoader classLoader = ReflectText.class.getClassLoader();
        //根据类加载器获取某个资源文件的路径同时生成输入流，该资源文件放在class文件中，一定放对
        InputStream properties1 = classLoader.getResourceAsStream("Properties");

        properties.load(properties1);
        String className = properties.getProperty("ClassName");
        String method = properties.getProperty("Method");

        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();

        Method method1 = aClass.getMethod(method,String.class);
        method1.invoke(o,"开心");
    }
}
