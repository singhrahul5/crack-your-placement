from typing import List


def find_bridges(node, parent, timer, dist, low, vis, result, adj):
    vis[node] = True
    timer[0] += 1
    dist[node] = low[node] = timer[0]

    for nbr in adj[node]:
        if nbr == parent:
            continue

        if vis[nbr]:
            low[node] = min(low[node], dist[nbr])
        else:
            find_bridges(nbr, node, timer, dist, low, vis, result, adj)

            low[node] = min(low[node], low[nbr])

            if low[nbr] > dist[node]:
                result.append([node, nbr])


def critical_connections(n: int, connections: List[List[int]]) -> List[List[int]]:
    vis = [False] * n
    dist = [0] * n
    low = [0] * n

    result = []
    adj = [[] for _ in range(n)]

    for u, v in connections:
        adj[u].append(v)
        adj[v].append(u)

    timer = [0]
    for node in range(n):
        if not vis[node]:
            find_bridges(node, -1, timer, dist, low, vis, result, adj)

    return result
