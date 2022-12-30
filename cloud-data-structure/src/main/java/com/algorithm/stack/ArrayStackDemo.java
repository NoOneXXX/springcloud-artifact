package com.algorithm.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        System.out.println(arrayStack.ifFull()+"****"+arrayStack.ifEmpty());
        arrayStack.list();
    }
}

class ArrayStack{
    private int maxSize;//栈的最大值
    private int[] stack; // 数组，数据模拟站，数据就放在数据中
    private int top  = -1;// 栈底 空的时候就是-1

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断是不是满
    public boolean ifFull(){
        return maxSize == top + 1;
    }

    //判断是不是空
    public boolean ifEmpty(){
        return top == -1;
    }

    public void push(int val){
        if (ifFull())
        {
            throw new RuntimeException("栈已经满了");
        }
        top++;
        stack[top] = val;
    }

    public int pop(){
        if (ifEmpty()){
            throw new RuntimeException("为空");
        }
        int temps = stack[top];
        top--;
        return temps;
    }

    public void list(){
        if (ifEmpty()){
            throw new RuntimeException("为空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈的顺序是%d，数值是%d\n", i, stack[i]);
        }
    }



}
