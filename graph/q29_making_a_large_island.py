from typing import List


def find_parent(node, parents):
    if parents[node] == node:
        return node

    parents[node] = find_parent(parents[node], parent)
    return parents[node]


def union(u, v, parents, ranks, sizes):
    u = find_parent(u, parents)
    v = find_parent(v, parents)

    if u == v:
        return

    if ranks[u] > ranks[v]:
        parents[v] = u
        sizes[u] += sizes[v]
    elif ranks[v] > ranks[u]:
        parents[u] = v
        sizes[v] += sizes[u]
    else:
        parents[v] = u
        ranks[u] += 1
        sizes[u] += sizes[v]


def largest_island(grid: List[List[int]]) -> int:
    n = len(grid)
    nxn = n * n

    # initialize union set
    parents = [i for i in range(nxn)]
    ranks = [0] * nxn
    sizes = [1] * nxn

    # merge to island if edges exists

    for row in range(n):
        for col in range(n):
            if grid[row][col] == 0:
                continue
            u = row * n + col

            if 0 <= row + 1 < n and grid[row + 1][col] == 1:
                v = u + n
                union(u, v, parents, ranks, sizes)

            if 0 <= col + 1 < n and grid[row][col + 1] == 1:
                v = u + 1
                union(u, v, parents, ranks, sizes)

    max_island_size = max(sizes)

    for row in range(n):
        for col in range(n):
            if grid[row][col] == 1:
                continue

            u = row * n + col

            island_set = set()

            if 0 <= row - 1 < n and grid[row - 1][col] == 1:
                v = u - n
                island_set.add(find_parent(v, parents))

            if 0 <= row + 1 < n and grid[row + 1][col] == 1:
                v = u + n
                island_set.add(find_parent(v, parents))

            if 0 <= col - 1 < n and grid[row][col - 1] == 1:
                v = u - 1
                island_set.add(find_parent(v, parents))

            if 0 <= col + 1 < n and grid[row][col + 1] == 1:
                v = u + 1
                island_set.add(find_parent(v, parents))

            island_size = 1
            for island in island_set:
                island_size += sizes[island]

            max_island_size = max(max_island_size, island_size)

    return max_island_size
