package com.rahul.crack_your_placement.linkedlist;

public class Q02_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow, fast;
        slow = head;
        fast = head.next;

        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast;
    }
}
