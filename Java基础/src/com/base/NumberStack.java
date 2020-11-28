package com.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class NumberStack {
    private static int Maxsize;
    private static double[] stack;
    private static int top = -1;

    public NumberStack(int Maxsize) {
        this.Maxsize = Maxsize;
        stack = new double[Maxsize];
    }

    public static boolean isEmpty() {
        if (top == -1) return true;
        return false;
    }

    public static boolean isFull() {
        if (top == Maxsize - 1) return true;
        return false;
    }

    public static double GetTop() {
        if (isEmpty()) throw new RuntimeException("没有元素,栈为空");
        return stack[top];
    }

    public static void Push(double number) {
        if (isFull()) throw new RuntimeException("空间已满");
        top++;
        stack[top] = number;
    }

    public static double Pop() {
        if (isEmpty()) throw new RuntimeException("栈空");
        double Prev = stack[top--];
        return Prev;
    }

    public static void Ope() {
        char PreChar = CharStack.Pop();
        double PreInt1;
        double PreInt2;
        switch (PreChar) {
            case '+':
                PreInt1 = NumberStack.Pop();
                PreInt2 = NumberStack.Pop();
                NumberStack.Push(PreInt2 + PreInt1);
                break;
            case '-':
                PreInt1 = NumberStack.Pop();
                PreInt2 = NumberStack.Pop();
                NumberStack.Push(PreInt2 - PreInt1);
                break;
            case '*':
                PreInt1 = NumberStack.Pop();
                PreInt2 = NumberStack.Pop();
                NumberStack.Push(PreInt2 * PreInt1);
                break;
            case '/':
                PreInt1 = NumberStack.Pop();
                PreInt2 = NumberStack.Pop();
                NumberStack.Push(PreInt2 / PreInt1);
                break;
            case '^':
                PreInt1 = NumberStack.Pop();
                PreInt2 = NumberStack.Pop();
                NumberStack.Push(Math.pow(PreInt2, PreInt1));
                break;
            case '!':
                double sum = 1;
                PreInt1 = NumberStack.Pop();
                for (int i = 1; i <= PreInt1; i++) {
                    sum *= i;
                }
                NumberStack.Push(sum);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        CharStack charStack = new CharStack(20);
        NumberStack numberStack = new NumberStack(20);
        int index = 0;
        while (true) {
             if (index == str.length()-1) {
                 break;
             }
            char aChar = str.substring(index, index + 1).charAt(0);
            String s = "";
            if(!Judge.JudgeOperate(aChar))
                s += aChar;                            //234+324;
            if (Judge.JudgeOperate(aChar)) {
                if (CharStack.isEmpty()) {
                    CharStack.Push(aChar);
                    index++;
                } else if (Judge.ArraysPriority(CharStack.GetTop(), aChar) == '>') {
                    Ope();
                } else if (Judge.ArraysPriority(CharStack.GetTop(), aChar) == '<') {
                    CharStack.Push(aChar);
                }
            } else {
                index++;
                aChar = str.substring(index, index + 1).charAt(0);
                if (index == str.length() - 1) NumberStack.Push(Double.parseDouble(s+aChar));
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
                    NumberStack.Push(Double.parseDouble(s));
                    s = "";
                }
            }
        }
        while (!CharStack.isEmpty()) {
            Ope();
        }
        System.out.println(NumberStack.GetTop());
    }


}
/*class CharStack{
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
    static char[] OPE = {'+', '-', '*', '/', '^', '!', '('};

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
}*/