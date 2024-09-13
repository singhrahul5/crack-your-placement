from collections import deque


def minStepToReachTarget(knight_pos, target_pos, n):
    # Code here
    moves = [[-2, -1], [-2, 1], [2, -1], [2, 1], [-1, -2], [1, -2], [-1, 2], [1, 2]]
    queue = deque()

    queue.append(knight_pos)

    vis = [[float('inf')] * (n + 1) for _ in range(n + 1)]
    vis[knight_pos[0]][knight_pos[1]] = 0
    while queue:
        kx, ky = queue.popleft()
        if kx == target_pos[0] and ky == target_pos[1]:
            return vis[kx][ky]

        for mx, my in moves:
            nx, ny = kx + mx, ky + my
            if 1 <= nx <= n and 1 <= ny <= n and vis[nx][ny] == float('inf'):
                vis[nx][ny] = vis[kx][ky] + 1
                queue.append([nx, ny])

    return -1

