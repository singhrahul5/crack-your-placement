class Node:
    def __init__(self, key=-1, val=-1, next_node=None, prev_node=None):
        self.key = key
        self.val = val
        self.next = next_node
        self.prev = prev_node


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_node(self, node):
        head_next = self.head.next
        self.head.next = node
        node.prev = self.head

        node.next = head_next
        head_next.prev = node

    def remove_node(self, node):
        next_node = node.next
        prev_node = node.prev

        prev_node.next = next_node
        next_node.prev = prev_node

    def remove_and_get_last(self):
        last = self.tail.prev
        self.remove_node(last)
        return last

    def get(self, key: int) -> int:
        if key in self.map:
            node = self.map[key]
            self.remove_node(node)
            self.add_node(node)
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            self.remove_node(node)
            self.add_node(node)
            node.val = value
        else:
            if len(self.map) == self.capacity:
                last = self.remove_and_get_last()
                del self.map[last.key]

            node = Node(key, value)
            self.add_node(node)
            self.map[key] = node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)