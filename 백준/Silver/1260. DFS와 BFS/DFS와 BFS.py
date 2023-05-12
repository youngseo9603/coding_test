import sys
from collections import deque
n, m, v = map(int, sys.stdin.readline().split())

line = [[False]*(n+1) for i in range(n+1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    line[a][b] = True
    line[b][a] = True

visited = [False for i in range(n+1)]

def dfs(x):
    print(x, end=" ")
    visited[x] = 1
    for i in range(len(line)):
        if not visited[i] and line[x][i]:
            dfs(i)

dfs(v)
print("")
visited = [False for i in range(n+1)]
def bfs(x):
    q = deque([x])
    visited[x] = 1
    while(q):
        node = q.popleft()
        print(node, end = " ")
        for i in range(1, n+1):
            if not visited[i] and line[node][i]:
                q.append(i)
                visited[i] = True
bfs(v)