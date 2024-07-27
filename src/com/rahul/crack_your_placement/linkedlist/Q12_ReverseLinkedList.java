package com.rahul.crack_your_placement.linkedlist;

public class Q12_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode curr, prev, next;
        curr = head;
        prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
