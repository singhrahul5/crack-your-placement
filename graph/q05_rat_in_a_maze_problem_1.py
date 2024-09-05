from typing import List


def dfs(row, col, n, mat, ans, path):
    if row < 0 or row >= n or col < 0 or col >= n or mat[row][col] == 0:
        return

    if row == n - 1 and col == n - 1:
        ans.append(path)
        return

    mat[row][col] = 0

    # down
    dfs(row + 1, col, n, mat, ans, path + 'D')
    # up
    dfs(row - 1, col, n, mat, ans, path + 'U')
    # left
    dfs(row, col - 1, n, mat, ans, path + 'L')
    # right
    dfs(row, col + 1, n, mat, ans, path + 'R')

    # backtrack
    mat[row][col] = 1


def findPath(m: List[List[int]]) -> List[str]:
    # code here
    ans = []

    dfs(0, 0, len(m), m, ans, '')

    return ans
