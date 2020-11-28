package com.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Before {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split =str.split( " ");
        for (String s : split) {
            list.add(s);
        }
        //Deque
        Stack<Double> stack = new Stack<>();//+ + 2.0000 * 3 - 7 4 / 8 4
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).matches("^[0-9]+([.]{1}[0-9]+){0,1}$")) {
                stack.push(Double.parseDouble(list.get(i)));
            } else {
                double num2;
                double num1;
                if (list.get(i).equals("+")) {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push((num1 + num2));

                } else if (list.get(i).equals("-")) {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num2 - num1);

                } else if (list.get(i).equals("*")) {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num2 * num1);

                } else if (list.get(i).equals("/")) {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num2 / num1);

                } else if (list.get(i).equals("^")) {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(Math.pow(num2, num1));

                } else if (list.get(i).equals("!")) {
                    double sum = 1;
                    num2 = stack.pop();
                    for (int j = 1; j <= num2; j++) {
                        sum *= j;
                    }
                    stack.push(sum);

                }
            }
        }
        System.out.println(stack.pop());
    }
}

