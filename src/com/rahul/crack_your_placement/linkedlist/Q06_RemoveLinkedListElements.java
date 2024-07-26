package com.rahul.crack_your_placement.linkedlist;

public class Q06_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr, dummy = new ListNode();

        dummy.next = head;
        curr = dummy;

        while(curr.next != null) {
            if(curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
