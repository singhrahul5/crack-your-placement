from typing import Optional

from linked_list.ListNode import ListNode


def deleteDuplicates(head: Optional[ListNode]) -> Optional[ListNode]:
    prev = dummy_head = ListNode(next_node=head)
    curr = head
    while curr:
        duplicate = False
        while curr.next and curr.val == curr.next.val:
            duplicate = True
            curr = curr.next
        if duplicate:
            prev.next = curr.next
        else:
            prev = prev.next
        curr = curr.next

    return dummy_head.next
