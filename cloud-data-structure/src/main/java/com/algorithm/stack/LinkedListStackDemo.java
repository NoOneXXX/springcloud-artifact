package com.algorithm.stack;

import java.util.Stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.printf("最后的pop数值是%d \n" , stack.pop());
        System.out.printf("最后的pop数值是%d \n" , stack.pop());
        System.out.printf("最后的pop数值是%d \n" , stack.pop());
        System.out.printf("最后的pop数值是%d \n" , stack.pop());
        stack.list();

        System.out.println("是否为空" + stack.isEmpty());
        Stack s = new Stack<String>();






    }
}

//利用链表来模拟栈
class LinkedListStack{
    private HeroNode first = new HeroNode(0);
    private int maxSize;

    public LinkedListStack(int maxSize){
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        return maxSize == count();
    }

    public boolean isEmpty(){
        return first.getNext() == null;
    }

    public void push(int vls){
        if (isFull())
        {
            System.out.println("已经满了！！！");
            return;
        }
        HeroNode temps = first;
        while (true){
            if (temps.getNext() == null){
                break;
            }
            temps = temps.getNext();
        }
        HeroNode node = new HeroNode(vls);
        temps.setNext(node);
    }

    public int pop(){
        HeroNode temps = first;
        while (true){
            if (temps.getNext().getNext() == null){
                break;
            }
            temps = temps.getNext();
        }
        int vls = temps.getNext().getValue();
        temps.setNext(null);
        return vls;
    }

    public void list(){
        HeroNode temps = first.getNext();
        while (true){
            if (temps == null){
                break;
            }
            System.out.printf("这个数值是:%d \n" , temps.getValue());
            temps = temps.getNext();
        }
    }

    //获得个数
    public int count(){
        int temps = 0;
        HeroNode node = first;
        while (true){
            if (node.getNext() == null) {
                break;
            }
            temps++;
            node = node.getNext();
        }
        return temps;
    }


}

class HeroNode{

    private int value;
    private HeroNode next;

    public HeroNode( int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}