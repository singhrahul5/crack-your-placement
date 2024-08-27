from typing import Optional

from linked_list.ListNode import ListNode


def reverse(head: Optional[ListNode]) -> Optional[ListNode]:
    prev = None
    while head:
        next_node = head.next
        head.next = prev
        prev = head
        head = next_node

    return prev


def remove_nth_from_end(head: Optional[ListNode], n: int) -> Optional[ListNode]:
    head = reverse(head)
    trav = dummy_head = ListNode(next_node=head)

    while n > 1:
        trav = trav.next
        n-=1

    trav.next = trav.next.next

    return reverse(dummy_head.next)
