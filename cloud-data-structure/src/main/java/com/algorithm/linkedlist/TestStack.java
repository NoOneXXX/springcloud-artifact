package com.algorithm.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        //test stack
        //入栈
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");
        //出栈
        while (stack.size() > 0){
            System.out.println(stack.peek());
        }
    }
}
