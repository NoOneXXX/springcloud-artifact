package com.algorithm.sort;

import java.util.Arrays;

//选择排序
public class SelectSort {
    public static void main(String[] args) {
        //创建一个随机数来测试 we create a random array numbers to testing
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++){
            arr[i] = (int) (Math.random() * 4000000);
        }
        System.out.println("before sorted");
       // System.out.println(Arrays.toString(arr));
        long times = System.currentTimeMillis();
        selectSort(arr);
        System.out.println("custom time is ====>" + (System.currentTimeMillis() - times) );

        System.out.println("after sorted");
       // System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j =i + 1 ; j < arr.length ; j++){
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        /** 这个是第一次的逻辑分析 一步步的分析结果  this is first logic analyse below coding with one step by step
        //首先为了清晰逻辑先进行第一轮排序 this is first select sorting for clear logic
        int minIndex = 0; //第一个索引
        int min = arr[0]; //第一个数

        for (int j =0 + 1 ; j < arr.length ; j++){
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        arr[minIndex] = arr[0];
        arr[0] = min;

        System.out.println("after first select sorted");
        System.out.println(Arrays.toString(arr));

        //第二轮排序
        minIndex = 1; //第一个索引
        min = arr[1]; //第一个数

        for (int j =1 + 1 ; j < arr.length ; j++){
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        arr[minIndex] = arr[1];
        arr[1] = min;

        System.out.println("after second select sorted");
        System.out.println(Arrays.toString(arr));


        //第三轮排序
        minIndex = 2; //第一个索引
        min = arr[2]; //第一个数

        for (int j =2 + 1 ; j < arr.length ; j++){
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (minIndex != 2) //如果位置没有变化就不用进行交换
        {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("after third select sorted");
        System.out.println(Arrays.toString(arr));
         */
    }
}
