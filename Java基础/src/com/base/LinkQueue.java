package com.base;


//继承式队列
/*
public class LinkQueue<E> extends LinkedList<E>{
    public static void main(String[] args) {
        LinkQueue<Integer> linkQueue = new LinkQueue<>();
        Scanner sc = new Scanner(System.in);
        StringBuffer sr=new StringBuffer(sc.next());
        //System.out.println(sr.length());
        sr.replace(sr.length()-1,sr.length(),",");
        String NewStr = sr.substring(1, sr.length());
        String[] split = NewStr.split(",");
        int[] num1=new int[sr.length()-1];
        int i2=0;
        for (String s : split) {
            num1[i2++]=Integer.parseInt(s);
        }
        for (int i1=0;i1<i2;i1++) {
            linkQueue.add(num1[i1]);
        }
        System.out.println(linkQueue.remove(0));
    }
}*/

import java.util.LinkedList;

//聚合方式实现队列
public class LinkQueue<T>{
   private LinkedList<T> Queue=null;
   public LinkQueue(){
      Queue=new LinkedList<T>();
    }
   public boolean isEmpty(){
       return Queue.isEmpty();
   }
   public T getFirst(){
       return Queue.getFirst();
   }
   public T GetLast(){
       return Queue.removeLast();
   }
   public boolean Add(T number){
       return Queue.add(number);
   }
   public T remove(){
       return Queue.remove(0);
   }

}
class Text{
    public static void main(String[] args) {
        LinkQueue<Integer> linkQueue = new LinkQueue<>();
        boolean empty = linkQueue.isEmpty();
        System.out.println(empty);
        linkQueue.Add(1);
        linkQueue.Add(3);
        linkQueue.Add(4);
        boolean empty1 = linkQueue.isEmpty();
        System.out.println(empty1);
        System.out.println(linkQueue.GetLast());
    }
}
