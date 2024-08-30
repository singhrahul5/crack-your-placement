from typing import Optional
from ListNode import ListNode


def partition(head: Optional[ListNode], x: int) -> Optional[ListNode]:
    first_head = first_tail = ListNode()
    second_head = second_tail = ListNode()

    curr = head
    while curr:
        next_node = curr.next
        curr.next = None
        if curr.val < x:
            first_tail.next = curr
            first_tail = first_tail.next
        else:
            second_tail.next = curr
            second_tail = second_tail.next
        curr = next_node

    first_tail.next = second_head.next

    return first_head.next
