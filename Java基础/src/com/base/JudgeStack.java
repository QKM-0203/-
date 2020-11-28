package com.base;

import java.util.Stack;

public class JudgeStack {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        //贪心算法，不从整体考虑，只考虑局部
        int j=0;
        int PopLen=popped.length;
        Stack<Integer> stack = new Stack<>();
        for (int i : pushed) {
            stack.push(i);
           // 每次判断栈顶是不是要pop的元素就行
            while(j<PopLen && stack.peek()==popped[j] && !stack.empty()){
                j++;
                stack.pop();
            }
        }
        return j==PopLen;
    }

    public static void main(String[] args) {
        int[] push={1,2,3,4,5};
        int[] pop={4,3,5,1,2};
        System.out.println(validateStackSequences(push,pop));
    }
}
