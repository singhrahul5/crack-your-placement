from typing import List


def sum_subarray_mins(arr: List[int]) -> int:
    prefix_total = 0
    stack = [-1]
    mod = int(1e9 + 7)

    ans = 0
    for i in range(len(arr)):
        while stack[-1] != -1 and arr[stack[-1]] >= arr[i]:
            pop = stack.pop()
            prefix_total = (prefix_total - arr[pop] * (pop - stack[-1])) % mod

        prefix_total = (prefix_total + arr[i] * (i - stack[-1])) % mod
        stack.append(i)
        ans = (ans + prefix_total) % mod

    return ans


