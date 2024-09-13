from typing import List


def dfs(row, col, last_num, n, m, matrix, dp):
    if not 0 <= row < n or not 0 <= col < m or matrix[row][col] <= last_num:
        return 0

    if dp[row][col]:
        return dp[row][col]

    curr_num = matrix[row][col]

    up = dfs(row - 1, col, curr_num, n, m, matrix, dp)
    down = dfs(row + 1, col, curr_num, n, m, matrix, dp)
    left = dfs(row, col - 1, curr_num, n, m, matrix, dp)
    right = dfs(row, col + 1, curr_num, n, m, matrix, dp)

    dp[row][col] = 1 + max(up, down, left, right)
    return dp[row][col]


def longest_increasing_path(matrix: List[List[int]]) -> int:
    n = len(matrix)
    m = len(matrix[0])

    dp = [[0] * m for _ in range(n)]

    ans = 0

    for i in range(n):
        for j in range(m):
            ans = max(ans, dfs(i, j, -1, n, m, matrix, dp))

    # return max([max(ele) for ele in dp])
    return ans
