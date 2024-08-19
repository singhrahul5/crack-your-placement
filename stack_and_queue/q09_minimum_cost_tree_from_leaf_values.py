from typing import List


class Solution:
    def using_stack(self, arr):
        res = 0
        stack = [float('inf')]

        for ele in arr:
            while stack[-1] <= ele:
                mid = stack.pop()
                res += mid * min(stack[-1], ele)
            stack.append(ele)

        while len(stack) > 2:
            res += stack.pop() * stack[-1]

        return res

    def mct_from_leaf_values(self, arr: List[int]) -> int:
        # dp = [[None for _ in arr] for _ in arr]

        # return self.solve(0, len(arr) - 1, arr, dp)[1]
        # return self.tab(arr)
        return self.using_stack(arr)

    def tab(self, arr):
        n = len(arr)
        max_arr = []
        for i in range(n):
            sub = [0] * n
            sub[i] = arr[i]
            for j in range(i + 1, n):
                sub[j] = max(sub[j - 1], arr[j])

            max_arr.append(sub)

        dp = [[0] * n for _ in range(n)]

        for left in range(n - 1, -1, -1):
            for right in range(left + 1, n):
                ans = float('inf')
                for div in range(left, right):
                    ans = min(ans, max_arr[left][div] * max_arr[div + 1][right] + dp[left][div] + dp[div + 1][right])
                dp[left][right] = ans

        return dp[0][n - 1]

    def solve(self, left: int, right: int, arr: List[int], dp: List[List[any]]) -> List[int]:
        if left == right:
            return [arr[left], 0]

        if dp[left][right] is not None:
            return dp[left][right]

        total = float('inf')
        max_leaf = 0

        for div in range(left, right):
            left_child = self.solve(left, div, arr, dp)
            right_child = self.solve(div + 1, right, arr, dp)

            if left_child[1] + right_child[1] + left_child[0] * right_child[0] < total:
                total = left_child[1] + right_child[1] + left_child[0] * right_child[0]
                # print(left, div, right, sum)
                max_leaf = max(left_child[0], right_child[0])

        dp[left][right] = [max_leaf, total]

        # print(left, right, dp[left][right])
        return dp[left][right]
