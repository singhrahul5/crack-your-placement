from typing import Optional, List

from linked_list.ListNode import ListNode


def mergeKLists(lists: List[Optional[ListNode]]) -> Optional[ListNode]:

    dummy_head = tail = ListNode()
    # remove empty linked-list from lists
    for index in range(len(lists) - 1, -1, -1):
        if not lists[index]:
            lists.pop(index)

    # merge linked list
    while lists:
        min_index = -1
        for index, node in enumerate(lists):
            if min_index == -1 or lists[min_index].val > node.val:
                min_index = index

        tail.next = lists[min_index]
        tail = tail.next

        if not lists[min_index].next:
            lists.pop(min_index)
        else:
            lists[min_index] = lists[min_index].next

    return dummy_head.next
