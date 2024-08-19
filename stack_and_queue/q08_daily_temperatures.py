from typing import List


def daily_temperatures(self, temperatures: List[int]) -> List[int]:
    stack = []
    ans = [0] * len(temperatures)

    for i in range(len(temperatures) - 1, -1, -1):
        while len(stack) != 0 and temperatures[stack[-1]] <= temperatures[i]:
            stack.pop()
        if len(stack) != 0:
            ans[i] = stack[-1] - i

        stack.append(i)

    return ans
