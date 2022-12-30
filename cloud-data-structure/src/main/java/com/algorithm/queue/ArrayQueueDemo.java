package com.algorithm.queue;

//队列数组
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        QueueArray queueArray = new QueueArray(5);
        for (int i = 0; i < 5; i++) {
            queueArray.addQueue(i);
        }
        queueArray.printArr();
        boolean isfull = queueArray.ifFull();
        boolean isEmpty = queueArray.isEmpty();
        System.out.println(isfull +"|||||" + isEmpty);
        System.out.println("the head is ====>" + "<<<<<<<<<<获取队列的长度------》" + queueArray.getSize());

    }
}

//创建数组队列对象 这样创建的队列会出现一个问题队列增加了数据，然后再取出来数据，虽然数据为空但是不能重复利用
class  QueueArray{
        private int maxSize;  //队列的最大容量
        private int front; //队列最前面得指针
        private int rear;  //队列最后的位置
        private int[] arr;  //队列存放的数据，模拟队列

        //构造函数
        public QueueArray(int maxSize_){
            maxSize = maxSize_;
            arr = new int[maxSize];
            front = -1; //指向队列头部， 指向队列头部的前一个位置
            rear = -1; // 指向队列尾部，指向队列的尾部（包含队列最后一个值）
        }

        //判断队列是否满
        public boolean ifFull(){
            return rear == maxSize - 1;
        }

        //判断队列是否为空
        public boolean isEmpty(){
            return rear == front;
        }

        //添加数据
        public void addQueue(int nums){
            //判断队列是否满
            if (ifFull())
            {
                throw new RuntimeException("队列已满！！！");
            }
            rear++;
            arr[rear] = nums;
        }

        //获取数据
        public int peek(){
            if (isEmpty()){
                throw new NullPointerException("队列为空!!!");
            }
            front++;
            return arr[front];
        }

        //打印队列
        public void printArr(){
            if (isEmpty())
                throw new NullPointerException("队列为空！！！");
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("队列的数据是: %d", arr[i]);
            }
        }

        //获取队列的长度
        public int getSize(){
            if(isEmpty())
                return 0;
            return arr.length;
        }
   }

