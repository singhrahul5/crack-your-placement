from typing import List


def dfs(row, col, n, m, grid):
    if row < 0 or row >= n or col < 0 or col >= m or grid[row][col] == "0":
        return

    grid[row][col] = "0"

    dfs(row + 1, col, n, m, grid)
    dfs(row - 1, col, n, m, grid)
    dfs(row, col + 1, n, m, grid)
    dfs(row, col - 1, n, m, grid)


def num_is_lands(grid: List[List[str]]) -> int:
    result = 0
    n = len(grid)
    m = len(grid[0])

    for row in range(n):
        for col in range(m):
            if grid[row][col] == "1":
                result += 1
                dfs(row, col, n, m, grid)

    return result
