class MyQueue:

    def __init__(self):
        self.stack_back = []
        self.stack_front = []

    def push(self, x: int) -> None:
        self.stack_back.append(x)

    def pop(self) -> int:
        self.shift()
        return self.stack_front.pop()

    def peek(self) -> int:
        self.shift()
        return self.stack_front[-1]

    def empty(self) -> bool:
        return len(self.stack_back) + len(self.stack_front) == 0

    def shift(self) -> None:
        if len(self.stack_front) == 0:
            while len(self.stack_back) > 0:
                self.stack_front.append(self.stack_back.pop())

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
