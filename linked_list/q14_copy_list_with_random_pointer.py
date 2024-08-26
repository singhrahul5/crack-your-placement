from typing import Optional

# Definition for a Node.
class Node:
    def __init__(self, x: int, next_node: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next_node
        self.random = random


def copy_random_list(head: Optional[Node]) -> Optional[Node]:
    if head is None:
        return None

    trav = head
    while trav is not None:
        next_node = trav.next
        copy_node = Node(trav.val, next_node)
        trav.next = copy_node

        trav = next_node

    trav = head
    while trav is not None:
        copy_node = trav.next
        if trav.random is not None:
            copy_node.random = trav.random.next

        trav = copy_node.next

    trav = head
    dummy_head = tail = Node(-1)

    while trav is not None:
        copy_node = trav.next
        tail.next = copy_node
        tail = copy_node

        trav.next = trav.next.next
        trav = trav.next

    return dummy_head.next

