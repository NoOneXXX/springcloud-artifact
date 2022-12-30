package com.algorithm.recursion;

public class Puzzle {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部设置成1
        for (int i = 0 ; i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        System.out.println("输出地图的情况是:");
        for (int i = 0 ;i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("找到了出路11111111111111:");
        //输出新的地图，小球走过，并标识过的递归
        for (int i = 0 ;i < 8; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯给小球找出路
    //说明 如果小球到map[6][5] 这个位置，则说明路找到了
    //约定：当 map[i][j]为0表示该点没有走过， 当1表示墙 3表示走过但是走不通
    //首先定一个策略，下->右->上->左，如果走通再回溯

    /**
     *
     * @param map 表示地图
     * @param i 表示开始节点
     * @param j 表示开始的节点
     * @return
     */
    public static boolean setWay(int[][] map, int i , int j){
        if(map[6][5] == 2){ //通路已经找到 ok
            return true;
        }else{
            if (map[i][j] == 0){//如果当这个节点没有走过
                //按照策略 下->右->上->左 走
                map[i][j] = 2;//假设这个点是可以走通的
                if (setWay(map, i+1, j)) { //向下走
                    return true;
                }else if(setWay(map, i, j+1)){ //向右走
                    return true;
                }else if (setWay(map, i-1, j)){ //向上走
                    return true;
                }else if(setWay(map, i, j-1)) {//向左走
                    return true;
                }else{
                    //说明该店走不通，是思路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
