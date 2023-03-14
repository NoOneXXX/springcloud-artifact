package com.algorithm.sort;

import java.util.Arrays;

/***
 * 插入排序
 * 把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中包含一个元素，无序表中包含有n-1个元素，排序过程中
 * 每次从无序表中取出第一元素，把它的排序码一次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为
 * 新的有序表
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arrs = {101,34,119,1,33,78,0,788,45};
        insertSort(arrs);
    }

    public static void insertSort(int[] arrs){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arrs.length; i++) {
            insertVal = arrs[i];
            insertIndex = i - 1; //即arrs[1]的前面这个数的下标

            //给insertVal 找到插入的位子
            //说明
            //1，insertIndex >=0 保证insertVal插入的位子不会越界
            //2，insertVal < arrs[insertIndex] 待插入的数，还没有找到插入的位置
            //3，就需要将arrs[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arrs[insertIndex]) {
                arrs[insertIndex + 1] = arrs[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex + 1
            //举例：
            if (insertIndex + 1 != i)
            {
                arrs[insertIndex + 1] = insertVal;
            }

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arrs));
        }


        //第一轮 {101, 34, 119, 1} => {34, 101, 119, 1}
        //定义插入的数
//        int insertVal = arrs[1];
//        int insertIndex = 1 - 1; //即arrs[1]的前面这个数的下标
//
//        //给insertVal 找到插入的位子
//        //说明
//        //1，insertIndex >=0 保证insertVal插入的位子不会越界
//        //2，insertVal < arrs[insertIndex] 待插入的数，还没有找到插入的位置
//        //3，就需要将arrs[insertIndex] 后移
//        while (insertIndex >= 0 && insertVal < arrs[insertIndex]) {
//            arrs[insertIndex + 1] = arrs[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，insertIndex + 1
//        //举例：
//        arrs[insertIndex + 1] = insertVal;
//        System.out.println("第一轮插入");
//        System.out.println(Arrays.toString(arrs));
//
//        //第二轮
//        insertVal = arrs[2];
//        insertIndex = 2 - 1; //即arrs[1]的前面这个数的下标
//
//        //给insertVal 找到插入的位子
//        //说明
//        //1，insertIndex >=0 保证insertVal插入的位子不会越界
//        //2，insertVal < arrs[insertIndex] 待插入的数，还没有找到插入的位置
//        //3，就需要将arrs[insertIndex] 后移
//        while (insertIndex >= 0 && insertVal < arrs[insertIndex]) {
//            arrs[insertIndex + 1] = arrs[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，insertIndex + 1
//        //举例：
//        arrs[insertIndex + 1] = insertVal;
//        System.out.println("第二轮插入");
//        System.out.println(Arrays.toString(arrs));
//
//        //第三轮
//        insertVal = arrs[3];
//        insertIndex = 3 - 1; //即arrs[1]的前面这个数的下标
//
//        //给insertVal 找到插入的位子
//        //说明
//        //1，insertIndex >=0 保证insertVal插入的位子不会越界
//        //2，insertVal < arrs[insertIndex] 待插入的数，还没有找到插入的位置
//        //3，就需要将arrs[insertIndex] 后移
//        while (insertIndex >= 0 && insertVal < arrs[insertIndex]) {
//            arrs[insertIndex + 1] = arrs[insertIndex];
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到，insertIndex + 1
//        //举例：
//        arrs[insertIndex + 1] = insertVal;
//        System.out.println("第三轮插入");
//        System.out.println(Arrays.toString(arrs));
    }
}
