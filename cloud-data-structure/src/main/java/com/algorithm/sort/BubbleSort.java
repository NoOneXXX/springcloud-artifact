package com.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        bubbleSort(arr);
        System.out.println("===after sorted array===");
        System.out.println(Arrays.toString(arr));
        /*
        //第二次循环
        for (int i = 0 ; i < arr.length - 1 - 1; i++){
            //如果前面的数据比后面的数据大 交换
            if (arr[i] > arr[i + 1])
            {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("the second circle round sort ");
        System.out.println(Arrays.toString(arr));

        //第三次循环
        for (int i = 0 ; i < arr.length - 1 - 2; i++){
            //如果前面的数据比后面的数据大 交换
            if (arr[i] > arr[i + 1])
            {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("the third circle round sort ");
        System.out.println(Arrays.toString(arr));

        //第四次循环
        for (int i = 0 ; i < arr.length - 1 - 3; i++){
            //如果前面的数据比后面的数据大 交换
            if (arr[i] > arr[i + 1])
            {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("the forth circle round sort ");
        System.out.println(Arrays.toString(arr));
        */
    }

    public static void bubbleSort(int[] arr){
        //为了容易理解 展示一下冒泡排序的过程 时间复杂度是O(n^2)
        //第一趟排序将最大的排在最后
        int temp = 0; //临时变量 用来替换
        boolean flag  = false; //优化使用
        for(int j  = 0; j < arr.length - 1 ; j++){
            for (int i = 0 ; i < arr.length - 1 - j; i++){
                //如果前面的数据比后面的数据大 交换
                if (arr[i] > arr[i + 1])
                {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
//            System.out.println("the "+(j+1)+" circle round sort ");
//            System.out.println(Arrays.toString(arr));
            if (!flag){ //在排序过程中 一次交换都没有发生
                break;
            }else{
                flag = false;  //发生了交换
            }
        }
    }
}
