class StockSpanner:

    def __init__(self):
        self.arr = []
        self.stack = [-1]

    def next(self, price: int) -> int:
        while self.stack[-1] != -1 and self.arr[self.stack[-1]] <= price:
            self.stack.pop()

        self.stack.append(len(self.arr))
        self.arr.append(price)

        return len(self.arr) - self.stack[-2] - 1

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)