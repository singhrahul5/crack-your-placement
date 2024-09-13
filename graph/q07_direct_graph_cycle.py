from typing import List


def isCyclic(v: int, adj: List[List[int]]) -> bool:
    # code here
    freq = [0] * v
    for node in adj:
        for vertex in node:
            freq[vertex] += 1

    queue = []

    for i in range(v):
        if freq[i] == 0:
            queue.append(i)

    visited = 0
    while queue:
        visited += 1
        front = queue.pop(0)

        for nbr in adj[front]:
            freq[nbr] -= 1

            if freq[nbr] == 0:
                queue.append(nbr)

    return visited != v


sett = {(0, 1), (1, 1)}

sett.remove((0, 1))
print(sett)