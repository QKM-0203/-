 package com.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class After {
    static String[] Str=new String[21];
    public static void main(String[] args) {
        int i=0;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        CharStack charStack = new CharStack(20);
        int index = 0;
        while (true) {
            String s = "";
            char aChar = str.substring(index, index + 1).charAt(0);
            if(!Judge.JudgeOperate(aChar))
                s += aChar;
            if (index == str.length()-1 && aChar!=')') {
                Str[i++]=String.valueOf(s);
                break;
            }//234+324;
            if (Judge.JudgeOperate(aChar)) {
                if (CharStack.isEmpty()) {
                    CharStack.Push(aChar);
                    index++;
                }else if(aChar=='('){
                    CharStack.Push(aChar);
                    index++;
                }else if(aChar==')'){
                    while(CharStack.GetTop()!='('){
                        Str[i++]=String.valueOf(CharStack.Pop());
                    }
                    char chars=CharStack.Pop();
                    if(index==str.length()-1) break;
                    index++;
                } else if (Judge.ArraysPriority(CharStack.GetTop(), aChar) == '>') {
                    Str[i++]=String.valueOf(CharStack.Pop());
                } else if (Judge.ArraysPriority(CharStack.GetTop(), aChar) == '<') {
                     CharStack.Push(aChar);
                     index++;
                }
                //ArrayList
            }else{   //2+3*(7-4)+8/4
                index++;
                aChar = str.substring(index, index + 1).charAt(0);
                if (index == str.length() - 1 && aChar!=')')    Str[i++]=s+aChar;
                else {
                    while (!Judge.JudgeOperate(aChar)) {
                        s+=aChar;
                        index++;
                        if(index==str.length()-1) {
                            aChar = str.substring(index, index + 1).charAt(0);
                            s+=aChar;
                            break;
                        }
                        aChar = str.substring(index, index + 1).charAt(0);
                    }
                    Str[i++]=s;
                    s = "";
                }

            }
        }
        while (!CharStack.isEmpty()) {
            Str[i++]=String.valueOf(CharStack.Pop());
        }
        int k=0;
        for (String s : Str) {
            if(s!=null)
                System.out.print(s);
            if(k<i-1)
                System.out.print(" ");
               k++;
            }
    }

}
class CharStack{
    private  static int Maxsize;
    private  static char[] stack;
    private static int top=-1;

    public CharStack(int Maxsize){
        this.Maxsize=Maxsize;
        stack=new char [Maxsize];
    }
    public static  boolean isEmpty(){
        if(top==-1) return true;
        return false;
    }
    public static  boolean isFull(){
        if(top==Maxsize-1) return true;
        return false;
    }
    public  static char GetTop(){
        if(isEmpty()) throw new RuntimeException("没有元素,栈为空");
        return stack[top];
    }
    public  static void Push(char  number){
        if(isFull()) throw new RuntimeException("空间已满");
        top++;
        stack[top]=number;
    }
    public static char Pop(){
        if(isEmpty()) throw new RuntimeException("栈空");
        char Prev=stack[top--];
        return Prev;
    }
}
class Judge {
    static char[] OPE = {'+', '-', '*', '/', '^', '!', '(',')'};

    public static char ArraysPriority(char StackTop, char chars) {
        char[][] Priority = {
                {'>', '>', '<', '<', '<', '<'},

                {'>', '>', '<', '<', '<', '<'},

                {'>', '>', '>', '>', '<', '<'},

                {'>', '>', '>', '>', '<', '<'},

                {'>', '>', '>', '>', '>', '<'},

                {'>', '>', '>', '>', '>', '>'},

                {'<', '<', '<', '<', '<', '<'}
        };
        return Priority[GetNum(StackTop)][GetNum(chars)];
    }

    public static int GetNum(char chars) {
        int val = -1;
        switch (chars) {
            case '+':
                val = 0;
                break;
            case '-':
                val = 1;
                break;
            case '*':
                val = 2;
                break;
            case '/':
                val = 3;
                break;
            case '^':
                val = 4;
                break;
            case '!':
                val = 5;
                break;
            case '(':
                val = 6;
                break;
        }
        return val;
    }

    public static boolean JudgeOperate(char chars) {
        for (char c : OPE) {
            if (c == chars) return true;
        }
        return false;
    }
}


