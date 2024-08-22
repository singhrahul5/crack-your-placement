def oranges_rotting(grid):
    # Code here
    n = len(grid)
    m = len(grid[0])

    def check(xx, yy):
        return 0 <= xx < n and 0 <= yy < m and grid[xx][yy] == 1

    queue = []
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 2:
                queue.append([i, j])

    time = 0
    while len(queue) > 0:
        size = len(queue)
        time += 1

        while size > 0:
            size -= 1
            x, y = queue.pop(0)

            if check(x - 1, y):
                grid[x - 1][y] = 2
                queue.append([x - 1, y])

            if check(x + 1, y):
                grid[x + 1][y] = 2
                queue.append([x + 1, y])

            if check(x, y - 1):
                grid[x][y - 1] = 2
                queue.append([x, y - 1])

            if check(x, y + 1):
                grid[x][y + 1] = 2
                queue.append([x, y + 1])

    for i in range(n):
        for j in range(m):
            if grid[i][j] == 1:
                return -1

    return max(0, time - 1)

