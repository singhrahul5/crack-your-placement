from typing import List


def solve(i, j, k, dp, boxes):
    if i > j: return 0
    if dp[i][j][k] > 0: return dp[i][j][k]

    _i, _k = i, k
    while i + 1 <= j and boxes[i + 1] == boxes[i]:
        i += 1
        k += 1

    result = (k + 1) ** 2 + solve(i + 1, j, 0, dp, boxes)

    for m in range(i + 1, j + 1):
        if boxes[i] == boxes[m]:
            result = max(result, solve(i + 1, m - 1, 0, dp, boxes) + solve(m, j, k + 1, dp, boxes))

    dp[_i][j][_k] = result
    return result


def tab(boxes):
    n = len(boxes)
    dp = [[[0] * (n + 1) for _ in range(n + 2)] for _ in range(n + 1)]

    for i in range(n - 1, -1, -1):
        for j in range(i, n):
            for k in range(i, -1, -1):
                result = (k + 1) ** 2 + dp[i + 1][j + 1][0]

                for m in range(i + 1, j + 1):
                    if boxes[i] == boxes[m]:
                        result = max(result, dp[i + 1][m - 1 + 1][0] + dp[m][j + 1][k + 1])

                dp[i][j + 1][k] = result
    return dp[0][n][0]


def remove_boxes(boxes: List[int]) -> int:
    # n = len(boxes)
    # dp = [[[0] * n for _ in range(n)] for _ in range(n)]

    # return solve(0, n-1, 0, dp, boxes)

    return tab(boxes)