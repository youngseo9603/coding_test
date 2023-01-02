import sys
t = int(input())
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def cabbage_bfs(y, x):
    queue = [(y,x)]

    while (queue):
        y,x = queue.pop(0)

        for i in range(len(dx)):
            nx = x + dx[i]
            ny = y + dy[i]
            if (ny>=0 and nx >=0 and ny< n and nx < m and visited[ny][nx] == False and cabbage[ny][nx] == True):
                visited[ny][nx] = True
                queue.append((ny,nx))



for i in range(t):
    count = 0
    m,n,k = map(int, sys.stdin.readline().split())

    cabbage = [[0 for col in range(m)] for row in range(n)]
    visited = [[False for col in range(m)] for row in range(n)]
    for j in range(k):
        a,b = map(int, sys.stdin.readline().split())
        cabbage[b][a] = 1

    for c in range(m):
        for d in range(n):
            if (cabbage[d][c]==1 and visited[d][c] == False):
                visited[d][c] = True
                cabbage_bfs(d, c)
                count = count+1


    print(count)








