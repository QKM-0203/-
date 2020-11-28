package com.base;


import java.util.Scanner;

//Java链表类
class ListNode<T>{
     T val;
    ListNode<T> next;
    public ListNode(T val){
        this.val=val;
        next=null;
    }

}
//将链表排序，用归并排序
/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode midList = MidList(head);
        ListNode right = midList.next;
        midList.next = null;

        ListNode le = sortList(head);
        ListNode ri = sortList(right);
        return Mergesort(le,ri);
    }
    private ListNode MidList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow,fast;
        slow = head;
        fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode Mergesort(ListNode l1,ListNode l2){
        ListNode listnode = new ListNode(-1);
        ListNode p = listnode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                listnode.next = l1;
                l1 = l1.next;
            }else {
                listnode.next = l2;
                l2 = l2.next;
            }
            listnode = listnode.next;
        }
        listnode.next = l1 == null ? l2 : l1;
        return p.next;
    }
}*/
/*
class LinkList<T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
         return new Operate();
    }
    private class Operate implements Iterator<T>{
        SolutionListNode sln=new SolutionListNode<T>();
        ListNode<T> Current=sln.GetFirst();
        int index=0;

        @Override
        public boolean hasNext() {
            //return (index)
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

}*/
public class SolutionListNode<T> {
   // private static int pos;

    ListNode<T> head=null,last=null,first=null;
    public static void main(String[] args) {
      

        //将一个字符串中的字符转为数字，只能是正数。
        Scanner sc= new Scanner(System.in);
        String s=sc.next();
        int[] number=new int[s.length()];
        int k=0,sum=0;
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(a<='9'&& a>='0') {
                while (a <= '9' && a >= '0') {
                    sum = sum * 10 + a - '0';
                    i++;
                    a = s.charAt(i);   //[1,2,3,4]
                }
                number[k++] = sum;
            }
            sum=0;
        }
        //PrintLink(first);
        //last.next=first;
       /* ListNode listNode = detectCycle(first);
        if(listNode!=null) {
            System.out.println("tail connects to node index " + pos);
        }else{
          System.out.println("no");
        }*/


    }/*
    public ListNode<T> Creat(int[] number,int k) {
        for (int i1 = 0; i1 < k; i1++) {
            ListNode<T> listNode = new ListNode<T>(number[i1]);
            if (first == null) {
                first = listNode;
                last = listNode;
            } else {
                last.next = listNode;
                last = listNode;
            }
        }
    }
    public   ListNode<T> GetFirst(){
        return first;
    }
    public static void PrintLink(ListNode L){
        while(L!=null){
            System.out.println(L.val);
            L=L.next;
        }
    }*/
    /*
    public static ListNode detectCycle(ListNode L){

        //哈希表法
        HashSet<ListNode> set=new HashSet<>();
        while(L!=null) {
            set.add(L);
            L = L.next;
            if (set.contains(L)) break;
        }
        return L;*/
        /*快慢指针法
        //判断是否有环，有环返回两个指针相遇的地方，没有返回null
        public static ListNode hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){

                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)return fast;
            }
            return null;
        }

        public static ListNode detectCycle(ListNode head) {

            ListNode fast = hasCycle(head); //先判断是否有环
            if (fast == null){
                return null;
            }
            ListNode slow = head;
            我们假设，链长为m（进入环之前的那一段，即-1起向前的一段），环长为n（图中指0-4的那一段）。
            在第一次判断时，我们假设这两个指针相遇在环中的k点。此时，慢指针运动了(m+k)的距离
            （中间可能有绕圈的情况，但不影响后面推理故不做解说），此时快指针运动了2(m+k)的长度，也到达了k点，
            说明慢指针再运动(m+k)的距离也能回到k点。从k点出发，绕环走(m+k)个距离又回到了k点，说明环的长度就是(m+k)。
            从环起点走到k点是k个长度，那么从k点走到环起点就是m个长度，而从链起点走到环起点也是m个长度，
            说明二者肯定能在环起点相遇。
          -3->->-2>-1->0->1->2->3->4->0
            后面的是个环
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }*/

    /*//链表合并1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first=null,last=null;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                if(first==null){
                    first=l1;
                    last=l1;
                    l1=l1.next;
                }else{
                    last.next=l1;
                    last=l1;
                }
            }else{
                if(first==null){
                    first=l2;
                    last=l2;
                }else{
                    last.next=l2;
                    last=l2;
                }
            }
        }
        last.next= l1==null?l2:l1;
        return first;
    }

    链表合并2;
        ListNode prhead=new ListNode(-1);
        ListNode prew=prhead;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                    prew.next=l1;
                    l1=l1.next;
            }else{
                 prew.next=l2;
                 l2=l2.next;
                }
            prew=prew.next;
        }
        prew.next= l1==null?l2:l1;
        return prhead.next;
    }
    }
    //链表合并3
    //递归
    if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

     */
}

