package com.base;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//map是一个双列集合，有一个键有一个值，键和值的数据类型可以不同，
//键和值一一对应，一个键只能有一个值，一个值可以有多多个键。
//HashMap（多线程）实现Map接口，由键和值组成，底层也是哈希表，无序集合，
//LinkedHashMap底层是哈希表+链表，有序的集合，


//通常与流相操作，并且是键值对的存在的
//Properties集合(线程安全)，此类和IO流结合使用，实现数据的持久存储，实现map接口，继承Hashtable
//特有方法setPropetry(Sting key,String value);
//setProppetry(String key);
public class MAp {
    public static void main(String[] args) throws IOException {
        show();
    }

    private static void show() throws IOException {
        //Properties集合
        Properties pro = new Properties();
        pro.setProperty("戚凯萌","168");
        //properties集合的遍历
        /*Set<String> set2 = pro.stringPropertyNames();//获得键转为set集合
        for (String s : set2) {
            System.out.println(s+pro.get(s));
        }*/

        /*Set<Map.Entry<Object, Object>> ob = pro.entrySet();
        for (Map.Entry<Object, Object> objectObjectEntry : ob) {
            System.out.println(objectObjectEntry.getValue());
        }*/
        //把集合中的临时数据，持久化写入硬盘中存储
        FileWriter fw = new FileWriter("D://4//src//b.txt");

        //将集合中的内容写到文件中
        pro.store(fw,"save data");
       fw.close();


        //将文件里面的键值对读到集合中（存储键值对的文件可以等号或者空格间隔
        //加上#就是注释不用读取了。
        //匿名代码块不用关闭资源
        pro.load(new FileReader("D://4//src//b.txt"));
        Set<String> set1 = pro.stringPropertyNames();
        for (String s : set1) {
            System.out.println(s+pro.get(s));
        }


        HashMap<String, String> map = new HashMap<>();
        String v1=map.put("qkm","hi");//添加元素，若没有相同建的，返回null
        //否则新的value覆盖并且返回新的value
        System.out.println(v1);///null
        //map集合不能直接用增强for循环或者迭代器遍历
        //map集合第一种遍历（键找值的方法）
        map.put("sc","hh");
        map.put("yq","yh");
        Set<String> set = map.keySet();//把键取出来放到一个集合里，然后根据键来获取值输出，也可使用迭代器
        for (String s : set) {
            System.out.println(s+"-"+map.get(s));
        }
        //迭代器获取
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(map.get(it.next()));
        }
        //map集合的第二种遍历
        //map接口中有一个内部接口创建一个Entry对象，记录键与值
        Set<Map.Entry<String, String>> entries = map.entrySet();//使用entry对象遍历，相当于set集合中存的是entry对象，这个entry
        //对象里面存的是键和值，并且该entry对象还有方法getKey() getValue(
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey());//获取key

        }
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());//获取key
        }

        //Hashmap自定义类型若为一个类中的某些属性，则必须重写equals和hashcode方法，和自定义hashset类型是一样的
        //LinkedHashMap底层哈希表+链表，有序集合和LinkedHashset主要的作用是一样的
        //Hashtable(单线程)，也是存键值，不能存null。
    }
}
