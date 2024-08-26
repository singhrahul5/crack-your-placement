from typing import Optional, Any

from ListNode import ListNode


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

def reverse(head: Optional[ListNode]) -> list[ListNode | None | Any]:
    tail = head
    prev = None
    while head:
        next_node = head.next
        head.next = prev
        prev = head
        head = next_node

    return [prev, tail]


def reverse_between(head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:


    first_tail = second_tail = None
    dummy_head = ListNode(next_node=head)

    trav = dummy_head
    index = 0

    while trav:
        if left - 1 == index:
            first_tail = trav
        if right == index:
            second_tail = trav
            break
        trav = trav.next
        index += 1

    # print(first_tail.val)
    # print(second_tail.val)

    second_head = first_tail.next
    first_tail.next = None

    third_head = second_tail.next
    second_tail.next = None

    second_head, second_tail = reverse(second_head)

    first_tail.next = second_head
    second_tail.next = third_head

    return dummy_head.next
