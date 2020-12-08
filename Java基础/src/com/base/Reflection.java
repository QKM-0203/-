import java.beans.DesignMode;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public String name;
    public int age;
    private int id = 1;

    public Reflection(String name,int age){
        this.name = name;
        this.age = age;
    }

    public Reflection(){

    }
    public void eat(){
        System.out.println("吃饭");
    }
     public void eat(String str){
         System.out.println(str+"吃饭");

     }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
       /*
           获取class对象的三种方法
           1 Class class = Class.forName("全类名");
           全类名就是完整路径包括包名。
           2 类名.class
           通过类名的属性来获取
           3 对象.getClass();
           同一个文件的字节码只会被加载一次，都是同一个class对象
        */
        //成员变量的获取，可以设置和修改值
        Class<Reflection> reflect = Reflection.class;

        /*
        //获取所有共有的成员变量
        Field[] fields = reflect.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
       //获取某一个的成员变量的对象，可以设置和获取他的值
        Field name = reflect.getField("name");
        System.out.println(name);
        Reflection reflection = new Reflection();
        //获取该成员变量的值，要传入一个对象就是根据以前的对象.成员变量来考虑，就是给该对象设置成员变量的值，
        //当你重新new一个新对象时，他的值还是原来的
        Object o = name.get(reflection);
        System.out.println(o);
        //设置该成员变量的值
        name.set(reflection,"123");
        System.out.println(reflection.name);

        //获取所有的成员变量，不区分共有私有
        Field[] declaredFields = reflect.getDeclaredFields();
        //同上

        //获取demo的class对象
        Class<demo> demoClass = demo.class;
        //获取demo的私有成员变量
        Field declaredFields1 = demoClass.getDeclaredField("id");
        //  但是不能直接获取私有的，会报错，但是可以通过强制反射来改变获取私有的，
        //会报错
        demo demo = new demo();
        //设置这个不会报错，称为暴力反射
        declaredFields1.setAccessible(true);
        Object o1 = declaredFields1.get(demo);
        System.out.println(o1);















        //获取构造方法的对象，可以创造出一个对象。
        //获取一个指定的有参的构造器,在上面必须定义一下
        Constructor<Reflection> constructor = reflect.getConstructor(String.class, int.class);
        //根据构造器创建该类的对象
        Reflection qkm = constructor.newInstance("qkm", 18);

        System.out.println(qkm.name);
        //创建无参构造器
       Constructor<Reflection> constructor1 = reflect.getConstructor();
        System.out.println(constructor1);
        Reflection reflection = constructor1.newInstance();
        System.out.println(reflection.name);
        */









        //获取方法，可以执行该方法,获取方法传递的是方法名称，和参数列表，执行方法也需要该类的对象
        //获取所有方法时会有父类的方法存在
        //无参方法
        Method eat = reflect.getMethod("eat");
        Reflection reflection = new Reflection();
        eat.invoke(reflection);

        //有参方法
        Method method = reflect.getMethod("eat",String.class);
        method.invoke(reflection, "qkm");


    }
}
