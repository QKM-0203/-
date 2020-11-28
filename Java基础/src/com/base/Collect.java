package com.base;

import java.io.Serializable;
import java.util.*;
//of方法JDK9以上才有
//只能使用Set Map List三个接口使用，返回的是一个List集合，并且该集合不能在被改变，同时setmap集合不能有重复元素，不然会抛出异常
//集合里面只能存入对象
 public class Collect {
    public static void main(String[] args) {

        //ArrayList(多线程)底层是一个数组,查询多的时候可以使用ArrayList,但是增删多的话不建议使用
       // LinkedList(多线程)链表式的集合,查询快，有很多特有的方法，不建议使用多态。
        LinkedList<String> linked = new LinkedList<>();
        linked.add("b");
        linked.addFirst("a");//向集合最前面添加一个元素，LinkedList特有方法
        linked.push("www");//和addfirst的效果是一样的
        linked.addLast("eee");//和add效果一样在最后添加
        linked.getFirst();//获取第一个元素
        linked.getLast();//获取最后一个元素
        linked.pop();//移除第一个元素 linked.removeFirst()效果一样
        //Vector集合 底层是一个数组(单线程)
        //set接口不包含重复重复元素，并且没有索引，所以不能用普通for循环遍历。
        //Hashset类实现set接口，底层是一个哈希表，查询速度非常快，没有索引，不能重复元素，不是顺序存储
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        //因为没有索引，所以通过迭代器来遍历元素，
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        // 也可以使用foreach
        for (Integer integer : set) {
            System.out.println(integer);
        }
        Integer integer = new Integer(1);
        Integer integer1 = new Integer(1);
        System.out.println(integer.equals(integer1));//包装类也重写了equals方法和hashcode方法
        /*哈希表（数组+链表）
        哈希值：是一个十进制数，不是地址值。
        Hashset不能有重复元素的原理，在增加的时候调用hashcode和equals方法，当hashcode相同时并且equals返回true则不存入集合中，若hashcode
        相同内容不同，则挂到该hashcode的链表上
        */
        //Hashcode自定义元素存储必须重写equals和hashcode(新生成一个类)
        Set<student> set1 = new HashSet<>();
        student student1 = new student(19,"戚凯萌");
        student student2 = new student(19,"戚凯萌");
        student student3 = new student(18,"申聪");
        set1.add(student1);
        set1.add(student2);
        set1.add(student3);
        System.out.println(set1);//可以看出是无序的,[student{age=18, name='申聪'}, student{age=19, name='戚凯萌'}]
        //LinkedHashSet（哈希表+链表）链表用来记录添加顺序的，有序不能重复
        LinkedHashSet<student> students = new LinkedHashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        System.out.println(students);//可以看出是有序的，但还是不能有重复元素
        // [student{age=19, name='戚凯萌'}, student{age=18, name='申聪'}]


        //可变参数
        //底层是一个数组，传递参数个数不同，创建不长度的数组来存参数
        //定义方法：修饰符 返回值 名字（数据类型...变量名）（用于参数类型确定后，参数个数不确定）
        System.out.println( method("qkm",10,34,23));//67
       //注意事项：只能有一个可变参数，
        //当有多个参数时，可变参数写在最后
       // public void method(int a,double b,String...arr)

        //Collections工具类，实现collection的类，里面有很多方法，且是静态的可以直接使用
       ArrayList<String> collection=new ArrayList<>();
        ListIterator<String> listIt = collection.listIterator();
        Collections.addAll(collection,"afd","aer","agt"); //添加好多元素,map集合好像不能一次添很多
        Collections.shuffle(collection);//打乱集合元素//只能用与List
        //Collections的一种排序
        Collections.sort(collection);
        System.out.println(collection);
       // Collections.sort(collection);//集合排序默认升序,Collections排序只能是对List进行set不可以
       //同样要是对一个类排序必须该类实现接口Comparable重写compareTo方法在 empArraysort 有一种写法。
        //如下还有一种更简单的
        //2
        /*
        @Override
        public int compareTo(Object o) {
        student o1=(student) o;
        return this.age-o1.age;//升序排序
        //return o1.age-this.age//降序
        }
         */
        //1
        /*
         @Override
    public int compareTo(Object o) {
        emp1 emp3=null;
        if(o instanceof emp1){
            emp3=(emp1) o;
        }
        if(emp3.age>this.age){
            return -1;
        }
        else if(emp3.age<this.age) return 1;
        else return 0;
    }
     */

        ArrayList<student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        Collections.sort(students1);
        System.out.println(students1);


        //Collections的二种排序(规定按什么来排序)
        //添加Comparator接口，用匿名内部类实现
        Collections.sort(students1, new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return o1.age-o2.age;//升序反之降序
            }
        });
        System.out.println(students1);
        System.out.println(collection);//[]//集合重写了toString方法
        System.out.println(collection.isEmpty());//判断集合是否为空
        collection.add("1");
        collection.add("2");
        collection.add("3");
        Object[] num=collection.toArray();//集合转为数组
        System.out.println(Arrays.toString(num));//数组重写了toString方法//将数组以这样的形式输出[1, 2, 3]
        for (Object o : num) {
           // o=(String) o;
            System.out.print(o);
        }


    }
    public static int method(String a,double b,int...arr){
       // arr就相当于一个数组，来存传过来的参数
       // 如果要进行运算遍历数组就可以
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
}
 class student implements Comparable,Serializable {
     //private static final long serialVersionUID=1L;
     public int age;
     public   String name;
     public int man;
    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

     @Override
     public String toString() {
         return "student{" +
                 "age=" + age +
                 ", name='" + name + '\'' +
                 ", man=" + man +
                 '}';
     }
//重写compareTo接口

    @Override
    public int compareTo(Object o) {
        student o1=(student) o;
        return this.age-o1.age;//升序排序
        //return o1.age-this.age//降序
    }
}
