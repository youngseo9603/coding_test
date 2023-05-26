import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

graph = [[]for i in range(n+1)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

res = []

for i in range(1, n+1):
    visited = [0] * (n+1)

    queue = deque([i])
    visited[i] = 1

    while(queue):
        target = queue.popleft()
        for j in graph[target]:
            if not visited[j]:
                visited[j] = visited[target] + 1
                queue.append(j)
    res.append(sum(visited))

print(res.index(min(res))+1)
