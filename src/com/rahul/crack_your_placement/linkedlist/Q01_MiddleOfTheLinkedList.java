package com.rahul.crack_your_placement.linkedlist;


public class Q01_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
