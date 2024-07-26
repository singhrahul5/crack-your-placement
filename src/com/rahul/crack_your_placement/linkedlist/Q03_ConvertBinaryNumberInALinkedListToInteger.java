package com.rahul.crack_your_placement.linkedlist;

public class Q03_ConvertBinaryNumberInALinkedListToInteger {
    ListNode reverse(ListNode head) {
        ListNode prev, curr, next;
        prev = null;
        curr = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public int getDecimalValue(ListNode head) {
        head = reverse(head);

        int ans = 0;
        int increase = 1;
        while(head != null) {
            ans += head.val * increase;
            increase *= 2;
            head = head.next;
        }

        return ans;
    }
}
