package com.algorithm.linkedlist;


import com.google.gson.Gson;

class DoubleLinkedListMainMethod{
    public static void main(String[] args) {
        DoubleNode f1 = new DoubleNode(1, "11", "22");
        DoubleNode f2 = new DoubleNode(2, "11", "22");
        DoubleNode f3 = new DoubleNode(3, "11", "22");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(f);
//        doubleLinkedList.add(f2);
//        doubleLinkedList.add(f1);
        doubleLinkedList.orderByQueue(f1);
        doubleLinkedList.orderByQueue(f2);
        doubleLinkedList.orderByQueue(f3);
        doubleLinkedList.displayList();
//        doubleLinkedList.deleteDoubleLinkedList(f1);
//        doubleLinkedList.displayList();
    }
}

public class DoubleLinkedList {
    //create head in the list
    private DoubleNode head = new DoubleNode(0,"","");

    //add data into this double linked list
    public void add(DoubleNode heroNode){
        //because the head node is stably,so we need a temp variable
        DoubleNode temp = head;
        while (true){
            //find the last list
            if (temp.next == null){
                break;
            }
            //if you can not find the last node then moving the node
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //delete node from list
    public void deleteDoubleLinkedList(DoubleNode doubleNode) {
        if (head.next == null)
            throw new RuntimeException("the list is empty");

        DoubleNode temp = head;
        while (true){
            if (temp == null){
                throw new RuntimeException("not find equal value!!!");
            }
            if(temp.no == doubleNode.no){
                temp.pre.next = temp.next;
                //because the node is possible the last node ,you need to check null point
                if(temp.next != null)
                    temp.next.pre = temp.pre;
                break;
            }
            temp = temp.next;
        }
    }

    public void displayList(){
        if(head.next != null)
            head = head;
        if (head.next == null){
            System.out.println("this list is empty no anything to showing");
        }
        DoubleNode temp  = head;
        while (true){
            if (temp == null){
                System.out.println("show all list in here!!!");
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public void orderByQueue(DoubleNode node) {
        DoubleNode temp = head;
        if (head.next == null)
        {
            temp.next = node;
            node.pre = temp;
        }else{
            temp = head.next;
            while (true){
                if(temp == null)
                    throw new RuntimeException("no find");
                //最后一个
               if (temp.next != null){//倒数第二个
                   if (temp.no >= node.no && temp.next.no < node.no){
                       DoubleNode dJson = temp.next.next;
                       Gson gson = new Gson();
                       String st = gson.toJson(dJson);
                       DoubleNode dn = gson.fromJson(st, DoubleNode.class);
                       temp.next = node;
                       node.pre = temp;
                       node.next = dn;
                       break;
                   }
               }else{
                   temp.next = node;
                   node.pre = temp;
                   break;
               }
                temp = temp.next;
            }
        }
    }

}

class DoubleNode{
    public int no;
    public String name;
    public String nickname;
    public DoubleNode next; //next node
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
