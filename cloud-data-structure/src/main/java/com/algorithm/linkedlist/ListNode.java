package com.algorithm.linkedlist;

// Java Program to Merge Two Sorted
// Linked Lists in New List
// Iteratively

import java.io.*;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class GFG {
    public static ListNode mergeTwoLists(ListNode l1,
                                         ListNode l2)
    {
        // New List
        ListNode result = new ListNode(-1);

        // variable to point the last node of the list.
        ListNode p = result;

        // Iterate the loop
        while (l1 != null && l2 != null) {
            // Find the smaller element and append it to the
            // list.
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            }

            else {
                p.next = l2;
                l2 = l2.next;
            }

            // Update the variable
            p = p.next;
        }

        // If anyone list become empty append the remaining
        // list element of other list.
        if (l1 == null) {
            p.next = l2;
        }

        else if (l2 == null) {
            p.next = l1;
        }

        // Return the resultant list without first extra
        // node
        return result.next;
    }

    // A utility function to print linked list
    static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // 1->3->5 LinkedList created
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);

        // 0->2->4 LinkedList created
        ListNode mergedhead = mergeTwoLists(head1, head2);

        printList(mergedhead);
    }
}
