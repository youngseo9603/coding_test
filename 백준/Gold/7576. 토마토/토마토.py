import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())

graph = []
for i in range(m):
    graph.append(list(map(int, sys.stdin.readline().split())))

queue = deque([])
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            queue.append([i,j])

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs():
    while(queue):
        x, y = queue.popleft()
        for i in range(4):
            if dx[i]+x >= 0 and dx[i]+x < m and dy[i]+y >= 0 and dy[i]+y < n and graph[dx[i]+x][dy[i]+y] == 0:
                graph[dx[i]+x][dy[i]+y] = graph[x][y] + 1
                queue.append([dx[i]+x, dy[i]+y])

bfs()

answer = -1
for i in graph:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
        answer = max(answer, j)

print(answer -1)
