package com.rahul.crack_your_placement.linkedlist;

public class Q13_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead, resultTail;
        resultHead = resultTail = new ListNode();

        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val/10;
            resultTail.next = new ListNode(val%10);
            resultTail = resultTail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null ) {
            int val = l1.val + carry;
            carry = val/10;
            resultTail.next = new ListNode(val%10);
            resultTail = resultTail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            carry = val/10;
            resultTail.next = new ListNode(val%10);
            resultTail = resultTail.next;
            l2 = l2.next;
        }

        if(carry > 0)
            resultTail.next = new ListNode(carry);

        return resultHead.next;
    }
}
