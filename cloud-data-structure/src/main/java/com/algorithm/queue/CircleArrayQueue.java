package com.algorithm.queue;

public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试
        System.out.println(3%3);
        CircleArray queueArray = new CircleArray(5);
        for (int i = 0; i < 4; i++) {
            queueArray.addQueue(i);
        }
        queueArray.printArr();
        boolean isfull = queueArray.isFull();
        boolean isEmpty = queueArray.isEmpty();
        System.out.println(isfull +"|||||" + isEmpty);
        System.out.println("the head is ====>" + "<<<<<<<<<<获取队列的长度------》" );

    }
}

//创建数组队列对象 这样创建的队列会出现一个问题队列增加了数据，然后再取出来数据，虽然数据为空但是不能重复利用
class  CircleArray {
    private int maxSize;  //队列的最大容量
    //front 的含义进行调整： front 指向队列的第一个元素，也就是说arr[front] 是首个元素
    // front 的初始值是 0
    private int front;
    // rear的含义调整： rear指向最后一个元素的后一位，因为希望空出一个位置
    //rear的初始值  = 0
    private int rear;  //队列最后的位置
    //存放数据
    private int[] arr;  //队列存放的数据，模拟队列
    //构造函数
    public CircleArray(int maxSize_){
        maxSize = maxSize_;
        arr = new int[maxSize];

    }
    //判断队列是不是满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //check whether is empty
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull())
            throw new RuntimeException("队列满了！！！");
        // add data into array
        arr[rear] = n;
        // let rear moving back and fetch mod
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空，不能取到");
        //this is first element in the array
        //1, first we need fetch front data from array then saving into temp variable
        //2, moving front ,consideration mod
        //3, return temp data
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }


    //打印队列
    public void printArr(){
        if (isEmpty())
            throw new NullPointerException("队列为空！！！");
        //mind: we need to from front loop,
        for (int i = front; i < front + size(); i++) {
            System.out.printf("队列的数据是: %d", arr[i % maxSize]);
        }
    }

    private int size(){
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;

    }



}

