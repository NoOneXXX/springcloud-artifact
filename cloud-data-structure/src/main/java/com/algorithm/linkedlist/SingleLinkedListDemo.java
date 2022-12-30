package com.algorithm.linkedlist;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        HeroNode f = new HeroNode(1, "时迁","鼓上骚");
//        HeroNode f1 = new HeroNode(2, "卢俊义","玉麒麟");
//        HeroNode f2 = new HeroNode(3, "杨志","铁面兽");
//        HeroNode f3 = new HeroNode(4, "史进","九纹龙");
//        HeroNode f4 = new HeroNode(5, "鲁智深","花和尚");
////        singleLinkedList.addOrderBy(f2);
////        singleLinkedList.addOrderBy(f);
////        singleLinkedList.addOrderBy(f3);
////        singleLinkedList.addOrderBy(f4);
////        singleLinkedList.addOrderBy(f1);
//
//
//        singleLinkedList.add(f);
//        singleLinkedList.add(f1);
//        singleLinkedList.add(f2);
//        singleLinkedList.add(f3);
//        singleLinkedList.add(f4);


//        singleLinkedList.showList();
//        HeroNode newHeroNode = new HeroNode(4, "史进___-","---九纹龙---");
//        singleLinkedList.updateNode(newHeroNode);
//        singleLinkedList.showList();
//        System.out.println("are you hurt ====>" + singleLinkedList.getSize());
//        singleLinkedList.delHeroNode(newHeroNode);
//        singleLinkedList.showList();

        //find single list size
//        System.out.println("are you hurt ====>" + singleLinkedList.getSize());
//        int c = 0;
//        HeroNode head = singleLinkedList.getHead();
//        while (true){
//            if (head.next == null)
//                break;
//            head = head.next;
//            c++;
//        }
        //find last k node

//        System.out.println("all single list size is ====>" + singleLinkedList.findLastNode(32));

//        singleLinkedList.reverseNode();
//        singleLinkedList.showList();
//        singleLinkedList.printDescOrder();


        //合并两个队列
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        HeroNode f = new HeroNode(51, "时迁","鼓上骚");
//        HeroNode f1 = new HeroNode(40, "卢俊义","玉麒麟");
//        HeroNode f2 = new HeroNode(30, "杨志","铁面兽");
//        HeroNode f3 = new HeroNode(2, "史进","九纹龙");
//        HeroNode f4 = new HeroNode(1, "鲁智深","花和尚");
//
//        singleLinkedList.add(f);
//        singleLinkedList.add(f1);
//        singleLinkedList.add(f2);
//        singleLinkedList.add(f3);
//        singleLinkedList.add(f4);

        HeroNode ff = new HeroNode(52, "时迁","鼓上骚");
        HeroNode ff1 = new HeroNode(44, "卢俊义","玉麒麟");
        HeroNode ff2 = new HeroNode(30, "杨志","铁面兽");
        HeroNode ff3 = new HeroNode(20, "史进","九纹龙");
        HeroNode ff4 = new HeroNode(1, "鲁智深","花和尚");
        HeroNode ff5 = new HeroNode(0, "鲁智深","花和尚");

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(ff);
        singleLinkedList1.add(ff1);
        singleLinkedList1.add(ff2);
        singleLinkedList1.add(ff3);
        singleLinkedList1.add(ff4);
        singleLinkedList1.add(ff5);
        singleLinkedList1.showList(null);

//        SingleLinkedList singleL = new SingleLinkedList();
////        HeroNode heroNode = singleL.combinTwoOrderSingle(singleLinkedList.getHead(), singleLinkedList1.getHead());
////        System.out.println("===================>" + heroNode);
//        singleL.showList(null);

    }
}

class SingleLinkedList{
    //create head in the list
    private HeroNode head = new HeroNode(0,"","");
    private int counts;

    public HeroNode combinTwoOrderSingle(HeroNode first, HeroNode second){

        HeroNode tempList = new HeroNode(0, "", "");
        HeroNode temp = tempList;
        HeroNode firstNode = first.next;
        HeroNode secondNode = second.next;

        while (true)
        {
            if (firstNode.next == null && secondNode.next == null)
            {
                break;
            }else{
                //从大到小
                if (firstNode.next != null && secondNode.next != null)
                {
                    if(firstNode.no > secondNode.no){
                        temp.next = firstNode;
                        firstNode = firstNode.next;
                        temp = temp.next;
                        continue;
                    }else if (firstNode.no < secondNode.no){
                        temp.next = secondNode;
                        secondNode = secondNode.next;
                        temp = temp.next;
                        continue;
                    }else {

                        HeroNode firstTemp = (HeroNode) SerializationUtils.clone(firstNode);
                        HeroNode secondTemp = (HeroNode) SerializationUtils.clone(secondNode);
                        temp.next = firstNode;
                        temp.next.next = secondNode;
                        temp = temp.next.next;
                        firstNode = firstNode.next;
                        secondNode = secondNode.next;
                        continue;
                    }
                }else if (firstNode.next == null)
                {
                    temp.next = secondNode;
                    break;
                }else if (secondNode.next == null){
                    temp.next = firstNode;
                    break;
                }
            }
        }
        return tempList;
    }

    public void reverseNode(){

        //if this is success ,then you need to do nothing
        if(head.next == null || head.next.next == null){
            return ;
        }
        HeroNode curr = head.next; //temp variable
        HeroNode next = null; //next
        HeroNode reverseNodeList = new HeroNode(0, "",""); //new reverse list
        while (curr != null){
            next = curr.next;
            curr.next = reverseNodeList.next;
            reverseNodeList.next = curr;
            curr = next;
        }
        head.next = reverseNodeList.next;

    }

    public void printDescOrder(){
        if (head.next == null){
            return;
        }
        HeroNode curr = head.next;
        Stack<HeroNode> stack = new Stack();
        while (curr != null)
        {
            stack.push(curr);
            curr = curr.next;
        }
        while (stack.size() > 0)
        {
            System.out.println("new desc print====>" + stack.pop());
        }
    }


    //add single list
    // do not care list order
    // 1, find the last node
    // 2, letting the last node point to new node
    public void add(HeroNode heroNode){
        //because the head node is stably,so we need a temp variable
        HeroNode temp = head;
        while (true){
            //find the last list
            if (temp.next == null){
                break;
            }
            //if you can not find the last node then moving the node
            temp = temp.next;
        }
        counts++;
        temp.next = heroNode;
    }

    public void updateNode(HeroNode heroNode){
        if(head.next == null){
            System.out.println("this is empty list ,you can not find anything");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else{
            System.out.println("you are not find node ");
        }
    }

    //delete
    public void delHeroNode(HeroNode heroNode){
        //add a temp
        HeroNode temp  = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            counts--;
            temp.next = temp.next.next;
        }else {
            System.out.println("donot find those node here!!!!");
        }
    }

    //find single size
    public int getSize(){
        return counts;
    }

    //find head
    public HeroNode getHead(){
        return head;
    }

    public void showList(HeroNode node){
//        if (node == null)
//        {
//
//        }
//        if(node.next != null)
//            head = node;
//        if (head.next == null){
//            System.out.println("this list is empty no anything to showing");
//        }


        HeroNode temp  = head;
        while (true){
            if (temp == null){
                System.out.println("show all list in here!!!1");
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //add order by
    public void addOrderBy(HeroNode heroNode){
        //assume head equal head
        HeroNode temp  = head;
        while (true)
        {
            if (temp.next == null){
                break;
            }else if (temp.next.no > heroNode.no){ //find next node
                break;
            }else if(temp.next.no == heroNode.no){
                throw new RuntimeException("this is equal data ,you can not add dupli ");
            }
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }


    //find last k node value
    public HeroNode findLastNode(int k){
        HeroNode temp = head;
        if (temp == null)
            return null;
        if (k > counts || counts - k <= 0){
            return null;
        }
        for (int i = 0 ; i < counts - k; i++){
            temp = temp.next;
        }
        return temp;
    }


}

class HeroNode implements Serializable {
    private static final long serialVersionUID = 1L;
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
