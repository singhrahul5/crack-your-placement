from typing import Optional

from ListNode import ListNode


def reverse(head: Optional[ListNode]) -> Optional[ListNode]:
    prev = None
    while head:
        next_node = head.next
        head.next = prev
        prev = head
        head = next_node

    return prev


def reorder_list(head: Optional[ListNode]) -> None:
    """
    Do not return anything, modify head in-place instead.
    """

    slow = head
    fast = head.next

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    second_head = reverse(slow.next)
    slow.next = None
    first_head = head.next

    tail = head
    while first_head:
        tail.next = second_head
        second_head = second_head.next
        tail = tail.next

        tail.next = first_head
        first_head = first_head.next
        tail = tail.next

    if second_head:
        tail.next = second_head
