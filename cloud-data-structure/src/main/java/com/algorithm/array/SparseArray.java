package com.algorithm.array;

public class SparseArray {
    public static void main(String[] args) {
        //稀疏数组   创建一个五子棋
        //0 代表没有子 1 黑色 2 蓝色
        int chessArr[][] = new int[11][11];
        chessArr[2][2] = 1;
        chessArr[3][3] = 2;
        //打印稀疏数组
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.printf("%d\t", chessArr[i][j]);
            }
            System.out.println();
        }

        //遍历二维数组找到数组的值有效个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0)
                    sum++;
            }
        }
        System.out.println("sum = " +sum);
        //实例化第一行数据
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

        //填充数据
        int count = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0)
                {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }

        //打印稀疏数组
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        //稀疏数组
        int rows = sparseArr[0][0];
        int cols = sparseArr[0][1];
        int sums = sparseArr[0][2];
        int restoreArr[][] = new int[rows][cols];
        for (int i = 1; i <= sums; i++) {
            int retriveRows = sparseArr[i][0];
            int retriveCols = sparseArr[i][1];
            int retriveNums = sparseArr[i][2];
            restoreArr[retriveRows][retriveCols] = retriveNums;
        }

        //打印恢复的数组
        System.out.println("=========================================================================================");
        for (int i = 0; i < restoreArr.length; i++) {
            for (int j = 0; j < restoreArr[i].length; j++) {
                System.out.printf("%d\t" , restoreArr[i][j]);
            }
            System.out.println();
        }



    }
}
