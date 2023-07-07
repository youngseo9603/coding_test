import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())

graph = []
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

queue = deque([])
visited = [[False for i in range(m)] for j in range(n)]

start = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            queue.append([i,j])
            graph[i][j] = 0
            start.append([i,j])
        elif graph[i][j] == 1:
            graph[i][j] = -1

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs():
    while(queue):
        x, y = queue.popleft()
        for i in range(4):
            if dx[i]+x >= 0 and dx[i]+x < n and dy[i]+y >= 0 and dy[i]+y < m and graph[dx[i]+x][dy[i]+y] != 0 and visited[dx[i]+x][dy[i]+y] == False:
                graph[dx[i]+x][dy[i]+y] = graph[x][y] + 1
                visited[dx[i]+x][dy[i]+y] = True
                queue.append([dx[i]+x, dy[i]+y])

bfs()

for i in graph:
    for j in i:
        print(j, end = " ")
    print()