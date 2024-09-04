from typing import Optional

from linked_list.ListNode import ListNode


def merge_sort(head:Optional[ListNode]) -> Optional[ListNode]:
    # base case for 0 or 1 length linked list
    if not head or not head.next:
        return head

    # find mid
    slow = head
    fast = head.next

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    list1 = head
    list2 = slow.next
    slow.next = None

    list1 = merge_sort(list1)
    list2 = merge_sort(list2)

    return merge_sorted_list(list1, list2)


def merge_sorted_list(list1: Optional[ListNode], list2: Optional[ListNode])-> Optional[ListNode]:
    dummy_head = tail = ListNode()

    while list1 and list2:
        if list1.val <= list2.val:
            tail.next = list1
            list1 = list1.next
        else:
            tail.next = list2
            list2 = list2.next
        tail = tail.next

    while list1:
        tail.next = list1
        list1 = list1.next
        tail = tail.next

    while list2:
        tail.next = list2
        list2 = list2.next
        tail = tail.next

    return dummy_head.next


def sort_list(head: Optional[ListNode]) -> Optional[ListNode]:
    return merge_sort(head)



