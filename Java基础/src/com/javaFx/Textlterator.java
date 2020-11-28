package com.id.itera;

//iterator 是一个接口,获取迭代器在collection接口中，有一个方法iterator(),就是返回的迭代器的实现类对象
//集合迭代器,不同集合的存取元素方法不同，所以用迭代器定义一个统一的操作元素的方式
/*
迭代器的使用：1.获取迭代器
2.判断是否有下一个元素hasNext()
3.取出下一个元素next()
 */
/*
使用泛型的好处：存什么类型，取什么类型。
把运行错误提升到编译错误
 */
/*
定义泛型（写成一个类）
创建对象的时候传递泛型
 */
/*
泛型的通配符？（代表未知的类型），在定义的时候不能用，参数传递的时候可以用
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;




public class Textlterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("易烊千玺");
        coll.add("迪丽热巴");
        coll.add("古力娜扎");
        //获取迭代器的实现类对象，通过接口的iterator方法调用
        Iterator<String> iterator = coll.iterator();//(后面是实现类对象，前面是一个接口)使用的也是多态
       //获取迭代器，会有一个指针指向索引-1.
        //取出集合中的所有元素
        while(iterator.hasNext()){//判断还有没有下一个元素
           System.out.println(iterator.next());//指针向后移一位
       }
       //定义一个含有泛型的方法

        /*
        boolean b = iterator.hasNext();
        System.out.println(b);
        System.out.println(iterator.next());
         */
        //自定义泛型类
        student<Integer> student = new student<>(1);
        System.out.println(student.getName());
        //调用自定义泛型方法
        System.out.println(Textlterator.stu(1));
        //接口的自定义泛型，接口为什莫泛型，实现类就是什莫泛型
        student<String> student1 = new student<>("戚凯萌");
        System.out.println(student1.getName());
        student1.method("er");
        //通配符泛型的使用？
        Collection<String> coll1=new ArrayList<>();
        Collection<Integer> coll2=new ArrayList<>();
        coll1.add("hh");
        coll2.add(12);
        print(coll1);
        print(coll2);
        //泛型的上限限定
    }
    //传递不同类型数据元素的集合的遍历//使用通配符？
    private static void print(Collection<?> list) {
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //前面的M为定义泛型，不定义不能使用
    public static <M> M stu(M m){
        //System.out.println(m);
        return m;
    }

}
//自定义泛型类，不确定是什莫类型，在创建对象的时候在填入
class student<I> implements st<I>{//此处为定义泛型


    private I name;

    public student(I name) {
        this.name = name;
    }

    public I getName() {
        return name;
    }


    @Override
    public <I> void method(I i) {
        System.out.println(i);
    }
}
interface st<I>{
     public <I> void method(I i);
}
