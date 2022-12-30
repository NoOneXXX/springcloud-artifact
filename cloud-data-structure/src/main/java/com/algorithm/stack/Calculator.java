package com.algorithm.stack;

public class Calculator {
    public static void main(String[] args) {
        //定义个变大时运算
        String expression ="3-2*6/12-2/2-67*2+1";
        ArrayStack2 stack2 = new ArrayStack2(10);
        int result = stack2.calSingelDigitExpression(expression);
        System.out.println();
        System.out.println("计算结果是:" + result);
    }
}
class ArrayStack2{
    private int maxSize;//栈的最大值
    private int[] stack; // 数组，数据模拟站，数据就放在数据中
    private int top  = -1;// 栈底 空的时候就是-1

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public int peek(){
        return stack[top];
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
  //运算符的优先级是由程序员自己决定的
    //数字越大，优先级越大
    public int priority(int oper){
        if (oper == '*' || oper =='/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '/' || val == '-' || val == '*';
    }

    //计算方法
    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public int calSingelDigitExpression(String exp){
        //创建两个栈，一个数字，一个符号
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义需要相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepNum = "";
        char ch = ' ';//将每次扫描得到char保存到ch
        while (true){
            //一次获得每个expression的每一个字符
            ch = exp.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断运算符的栈是不是为空
                if (!operStack.ifEmpty()){
                    //不为空就从数字的栈中弹出两个数字，然后运算符的栈中弹出一个数，将计算的结果再次保存到数字栈中
                    if (operStack.priority(ch) > operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        index++;//将位置后移一位查找数字
                        //找到下一个数字放进数组中，不放进去也可以，不放的话就直接的赋值给num2
                        while (true){
                            char ch_temp = exp.substring(index, index + 1).charAt(0);
                            if (!operStack.isOper(ch_temp))
                            {
                                keepNum += ch_temp;
                                if (index == exp.length() - 1) {
                                    numStack.push(Integer.parseInt(keepNum));
                                    break;
                                }else{
                                    //判断下一个字符是不是数字，如果是数字就继续，如果是运算符，就入栈
                                    //注意是往后看一位，不是index++

                                    if (operStack.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                                        // 如果后一位是运算符，则入栈keepNum = “1”
                                        numStack.push(Integer.parseInt(keepNum));
                                        keepNum = "";
                                        break;
                                    }
                                }
                            }else {
                                break;
                            }
                            index++;
                        }
                        num2 = numStack.pop();
                        //oper = operStack.pop();
                        int temps = operStack.cal(num1, num2, ch);
                        numStack.push(temps);
                        //operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    //如果为空直接入栈
                    operStack.push(ch);
                }
            }else{
                //如果是数字就直接的入栈
                //numStack.push(ch - 48); //根据ascii码来计算 这样写只能计算个位数
                //分析思路
                //1, 当处理多位数时，不能发现是一个数就立马入栈，因为他可以是多位数
                //2，在处理数，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                //3，因此我们需要定义一个变量字符串，用于拼接

                //处理多位数
                keepNum += ch;

                if (index == exp.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    //判断下一个字符是不是数字，如果是数字就继续，如果是运算符，就入栈
                    //注意是往后看一位，不是index++

                    if (operStack.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是运算符，则入栈keepNum = “1”
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //让index + 1 并判断是否扫描到expression最后
            index++;
            if (index >= exp.length()) {
                break;
            }
        }

        //当表达式扫面完毕，就顺序的从数栈和符号栈pop数据计算
        while (true){
            if (operStack.ifEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            if (!operStack.ifEmpty())
            {
                int oper_next = operStack.peek();
                if (oper_next % 45 == 0 && oper % 43 == 0)
                    oper = '-';
                else if (oper_next % 45 == 0 && oper % 45 == 0)
                    oper = '+';
            }
            int temps = operStack.cal(num1, num2, oper);
            numStack.push(temps);
        }
        int results = numStack.pop();
        System.out.printf("表达式%s = %d", exp, results);
        return results;
    }
}
