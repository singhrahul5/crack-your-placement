package com.rahul.crack_your_placement.linkedlist;

public class Q09_IntersectionOfTwoLinkedLists {
    ListNode reverse(ListNode head) {
        ListNode prev, curr,next;
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode rHeadA, rTailA, slow, fast;
        rTailA = headA;
        rHeadA = reverse(headA);

        rTailA.next = headB;

        slow = rHeadA;
        fast = rHeadA.next;

        while(fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null || fast.next == null) {
            rTailA.next = null;
            reverse(rHeadA);
            return null;
        }

        slow = rHeadA;
        fast = fast.next;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        rTailA.next = null;
        reverse(rHeadA);
        return  slow;
    }
}
