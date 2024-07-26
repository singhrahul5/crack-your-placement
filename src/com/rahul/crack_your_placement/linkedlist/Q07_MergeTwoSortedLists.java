package com.rahul.crack_your_placement.linkedlist;

public class Q07_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1, head2, dummyHead, resultTail;
        resultTail= dummyHead = new ListNode();
        head1 = list1;
        head2 = list2;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                resultTail.next = head1;
                head1 = head1.next;
            } else {
                resultTail.next = head2;
                head2 = head2.next;
            }
            resultTail = resultTail.next;
        }

        while(head1 != null ) {
            resultTail.next = head1;
            head1 = head1.next;

            resultTail = resultTail.next;
        }

        while(head2 != null) {
            resultTail.next = head2;
            head2 = head2.next;

            resultTail = resultTail.next;
        }


        return dummyHead.next;
    }
}
