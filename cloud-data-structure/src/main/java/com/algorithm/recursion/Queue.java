package com.algorithm.recursion;


public class Queue {
    //定义一共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后位置结果
    int[] array = new int[max];
    public static void main(String[] args) {
        //测试
        Queue queue = new Queue();
        queue.check(0);

    }

    //特别注意：check是每次递归时，进入到check 都会有for循环
    private void check(int n){
        if (n == max){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        //以此放入皇后，并判断是否冲突
        for(int i = 0; i < max ; i++){
            //先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到第i列时，是否冲突
            if(judge(n)){
                //接着放n+1，即开始递归
                check(n+1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            /**说明
             * 1，array[i] == array[n] 表示判断 第n个皇后是否和前面的n-1个皇后同一列
             * 2，math.abs(n-1) == math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后在同一斜线
             * 3，判断是否在同一行，没有必要，n每次都在变动
             */
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
}
