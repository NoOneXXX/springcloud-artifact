package com.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序也是一种插入排序，它是简单插入排序经过改之后的一个更高的版本，也成为缩小增量排序
 * 希尔排序的基本思想
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序，随着增量逐渐减少
 * 每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法变终止lou'zhe
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        shellSort2(arr);
    }

    //使用逐步方法来编写希尔排序
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //根据逐步分析 使用循环处理
        for (int gap = arr.length / 2; gap > 0;gap /=2){
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组种的所有元素(共gap组，每组有2个元素) 步长gap
                for(int j = i - gap; j >=0 ; j -= gap){
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第"+(++count)+"轮" + Arrays.toString(arr));
        }



        // 希尔排序的第1轮
        // 因为是第1轮 将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组种的所有元素(共5组，每组有2个元素) 步长5
            for(int j = i - 5; j >=0 ; j -=5){
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序的第1轮" + Arrays.toString(arr));

        // 希尔排序的第2轮
        // 因为是第2轮 将10个数据分成了5/2 = 2组
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组种的所有元素(共2组，每组有5个元素) 步长2
            for(int j = i - 2; j >=0 ; j -=2){
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序的第2轮" + Arrays.toString(arr));


        // 希尔排序的第3轮
        // 因为是第3轮 将10个数据分成了2/2 = 1组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组种的所有元素(共1组，每组有10个元素) 步长1
            for(int j = i - 1; j >=0 ; j -=1){
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序的第3轮" + Arrays.toString(arr));
    }

    //使用移位法排序 前面的交换法因为每次都会交换导致大量的性能损耗 不建议使用
    public static void shellSort2(int[] arr){
        //增量gap 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从gap个元素 诸葛对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后 就给temp找个位置
                    arr[j] = temp;
                }

            }
        }

    }
}
