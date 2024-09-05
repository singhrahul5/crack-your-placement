from typing import List, Optional


def find_cycle(curr: int, parent: Optional[int], adj: List[List[int]], vis: List[bool]) -> bool:
    if vis[curr]:
        return True

    vis[curr] = True

    for nbr in adj[curr]:
        if nbr != parent and find_cycle(nbr, curr, adj, vis):
            return True

    return False


def isCycle(v: int, adj: List[List[int]]) -> bool:
    # Code here
    vis = [False] * v

    for vertex in range(v):
        if not vis[vertex] and find_cycle(vertex,None, adj, vis):
            return True
    return False
