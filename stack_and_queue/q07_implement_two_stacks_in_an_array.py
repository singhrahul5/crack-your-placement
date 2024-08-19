class TwoStacks:
    def __init__(self):
        self.arr = [0]*101
        self.top1 = -1
        self.top2 = 101
    # Function to push an integer into stack 1
    def push1(self, x):
        self.top1 += 1;
        self.arr[self.top1] = x

    # Function to push an integer into stack 2
    def push2(self, x):
        self.top2 -= 1;
        self.arr[self.top2] = x

    # Function to remove an element from top of stack 1
    def pop1(self):
        if self.top1 == -1:
            return -1
        ans = self.arr[self.top1]
        self.top1 -= 1
        return ans
    # Function to remove an element from top of stack 2
    def pop2(self):
        if self.top2 == 101:
            return -1
        ans = self.arr[self.top2]
        self.top2 += 1
        return ans