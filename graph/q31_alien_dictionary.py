from typing import List


def topo_sort_bfs(adj, k):
    in_degree = [0] * k

    for u in adj:
        for v in u:
            in_degree[v] += 1

    queue = []

    for u, degree in enumerate(in_degree):
        if degree == 0:
            queue.append(u)
    # print(adj)
    # print(queue)
    ans = ""
    while queue:
        front = queue.pop(0)
        ans += chr(97 + front)

        for nbr in adj[front]:
            in_degree[nbr] -= 1
            if in_degree[nbr] == 0:
                queue.append(nbr)
    # print(ans)
    return ans


def find_order(dictionary: List[str], n: int, k: int) -> str:
    # Your implementation here
    adj = [[] for _ in range(k)]
    # print(adj)

    for index in range(1, n):
        word1 = dictionary[index - 1]
        word2 = dictionary[index]

        idx = 0
        while idx < len(word1) and idx < len(word2) and word1[idx] == word2[idx]:
            idx += 1

        if idx < len(word1) and idx < len(word2):
            adj[ord(word1[idx]) - 97].append(ord(word2[idx]) - 97)

    return topo_sort_bfs(adj, k)
