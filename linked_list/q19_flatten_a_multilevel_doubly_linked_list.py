from typing import Optional, Tuple


# Definition for a Node.
class Node:
    def __init__(self, val, prev, next_node, child):
        self.val = val
        self.prev = prev
        self.next = next_node
        self.child = child

def flatten_util(head) -> Tuple[Node, Node]:
    curr = head
    tail = None
    while curr:
        curr.prev = tail
        if curr.child:
            sub_head, sub_tail = flatten_util(curr.child)
            next_node = curr.next

            sub_head.prev = curr
            curr.next = sub_head

            sub_tail.next = next_node
            # if next_node:
            #     next_node.prev = sub_tail
            curr.child = None
            curr = sub_tail

        tail = curr
        curr = curr.next

    return head, tail

def flatten(head: Optional[Node]) -> Optional[Node]:
    flatten_util(head)
    return head
