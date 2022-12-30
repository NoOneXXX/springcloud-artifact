package com.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//逆波兰表达式得计算 这个也叫做后缀表达式
public class PolandNotation {
    public static void main(String[] args) {
        //后缀表达式，使用逆波兰表达计算 为了方便使用空格隔开
        //(3+4)*5 - 6 ==> 3 4 + 5 * 6 -
//        String suffixExpression = "3 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpression);
        System.out.println("start====>" + list);
        int res = calculate(list);
        System.out.println("get result is =====>" + res);

    }
    //将一个逆波兰表达式，依次讲数据和运算符 放入arraylist中
    public static List<String> getListString(String suffixExpression){
        //分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
//计算
    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item: ls){
            if(item.matches("\\d+")){
                //入栈
                stack.push(item);
            }else {
                //pop 出两个数字，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)){
                    res = num1 + num2;
                }else if ("-".equals(item)){
                    res = num1 - num2;
                }else if("*".equals(item)){
                    res = num1 * num2;
                }else if ("/".equals(item)){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符没有!!!");
                }
                //入栈
                stack.push("" + res);
            }
        }
        //最后留在栈里面得数据就是结果
        return Integer.parseInt(stack.pop());
    }

    //中缀表达式转后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();
        //说明： 因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还要逆序输出比较麻烦
        //这里我们用arraylist来代替
        List<String> s2 = new ArrayList<>();
        return s2;
    }
}

