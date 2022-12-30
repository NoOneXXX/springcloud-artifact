package com.algorithm.linkedlist;

//约瑟夫环问题
public class Josefu {
    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.addBoy(5);
        circleSingleList.showBoy();

        circleSingleList.countBy(1,2,5);
    }
}
class CircleSingleList{
    private Boy first = null;

    //添加
    public void addBoy(int nums){
        if (nums < 1)
            System.out.println("数字不能小于1");

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    //根据用户的输入，计算出小孩出圈的顺序
    /**
     * @author echo_w
     * @createTime 2022/12/14 13:52
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     * @param startNo 表示从第几个小孩开始数数
     *
     */

    public void countBy(int startNo,int countNum, int nums){
        //对数据进行校验
        if(first == null || startNo < 1 || startNo < nums)
        {
            System.out.println("输入的参数有误，请重新输入!!!!");
        }
        //创建一个辅助指针，帮助小孩完成出圈
        Boy helper = first;
        //需求创建一个辅助指针(变量)helper，事先应该指向环行链表的最后这个节点
        while (true){
            if (helper.getNext() == first) { //说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first 和 helper 移动 k - 1 次
        for(int j = 0 ; j < startNo - 1 ; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时的移动m - 1 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true){
            if (helper == first) {
                break;
            }
            //让first 和 helper 指针同时移动countNum - 1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是小孩要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将小孩first
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是%d \n", first.getNo());
    }




    public void showBoy(){
        if (first == null)
        {
            System.out.println("这个集合为空，没有啥人啊!!!");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("当前的人员是%d \n", curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();

        }

    }
}

class Boy{
    private int no; //顺序
    private Boy next; //指向

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}