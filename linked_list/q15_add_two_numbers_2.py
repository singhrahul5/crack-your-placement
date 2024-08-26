# Definition for singly-linked list.
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


def add_two_numbers(l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    l1 = reverse(l1)
    l2 = reverse(l2)

    dummy_head = tail = ListNode()
    carry = 0
    while l1 and l2:
        num = l1.val + l2.val + carry
        carry = num // 10
        tail.next = ListNode(num % 10)
        tail = tail.next
        l1 = l1.next
        l2 = l2.next

    while l1:
        num = l1.val + carry
        carry = num // 10
        tail.next = ListNode(num % 10)
        tail = tail.next
        l1 = l1.next

    while l2:
        num = l2.val + carry
        carry = num // 10
        tail.next = ListNode(num % 10)
        tail = tail.next
        l2 = l2.next

    if carry:
        tail.next = ListNode(carry)

    return reverse(dummy_head.next)

