package com.rahul.crack_your_placement.linkedlist;

public class Q11_PalindromeLinkedList {
    ListNode middleNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while(fast != null) {
            slow = slow.next;
            fast = (fast.next == null)? null : fast.next.next;
        }
        return slow;
    }
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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode revHead = reverseList(mid);

        while(revHead != null) {
            if(head.val != revHead.val)
                return false;

            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }
}
