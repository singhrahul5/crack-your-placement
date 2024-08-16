class MyStack:

    def __init__(self):
        self.q1 = []
        self.q2 = []

    def push(self, x: int) -> None:
        self.q1.append(x)

    def pop(self) -> int:
        size = len(self.q1)
        while size > 1:
            self.q2.append(self.q1.pop(0))
            size -= 1

        self.q1, self.q2 = self.q2, self.q1
        return self.q2.pop(0)

    def top(self) -> int:
        size = len(self.q1)
        while size > 1:
            self.q2.append(self.q1.pop(0))
            size -= 1

        ans = self.q1.pop(0)
        self.q2.append(ans)
        self.q1, self.q2 = self.q2, self.q1
        return ans

    def empty(self) -> bool:
        return len(self.q1) == 0


# Your MyStack object will be instantiated and called as such:
obj = MyStack()
obj.push(10)
param_2 = obj.top()
param_3 = obj.pop()
param_4 = obj.empty()

print(param_2, param_3, param_4)
