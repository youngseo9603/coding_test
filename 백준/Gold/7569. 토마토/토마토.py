from collections import deque

m, n, h = map(int, input().split())

graph = [[[0 for i in range(m)] for j in range(n)] for k in range(h)]
stack = deque()
visited = [[[0 for i in range(m)] for j in range(n)] for k in range(h)]
day = [[[0 for i in range(m)] for j in range(n)] for k in range(h)]
for i in range(h):
    for j in range(n):
        temp = list(input().split())
        for z in range(m):
            graph[i][j][z] = int(temp[z])
            if graph[i][j][z] == 1:
                stack.append([i,j,z])
                visited[i][j][z] = 1

dx = [0,0,0,0,1,-1]
dy = [0,0,1,-1,0,0]
dz = [1,-1,0,0,0,0]
while(stack):
    a,b,c = stack.popleft()

    for i in range(6):
        x = a + dx[i]
        y = b + dy[i]
        z = c + dz[i]
        if 0 <= x < h and 0 <= y < n and 0 <= z < m and graph[x][y][z] == 0 and visited[x][y][z] == 0:
            visited[x][y][z] = 1
            stack.append([x,y,z])
            day[x][y][z] = day[a][b][c] + 1

answer = 0
for i in range(h):
    for j in range(n):
        for z in range(m):
            if visited[i][j][z] == 0 and graph[i][j][z] == 0:
                print(-1)
                exit(0)
            answer = max(answer, day[i][j][z])

print(answer)