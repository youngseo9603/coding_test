n = int(input())

graph = [[0 for i in range(n)] for j in range(n)]
visited = [[0 for i in range(n)] for j in range(n)]
for i in range(n):
    temp = input()
    for j in range(n):
        graph[i][j] = int(temp[j])

dx = [0,0,-1,1]
dy = [1,-1,0,0]

pieces = 0
big = []

for i in range(n):
    for j in range(n):
        if visited[i][j] == 0 and graph[i][j] == 1:
            stack = [[i,j]]
            visited[i][j] = 1
            pieces += 1
            b = 1
            while stack:
                x, y = stack.pop(0)

                for k in range(4):
                    if 0 <= x + dx[k] < n and 0 <= y + dy[k] < n and visited[x+dx[k]][y+dy[k]] == 0 and graph[x+dx[k]][y+dy[k]] == 1:
                        visited[x + dx[k]][y + dy[k]] = 1
                        stack.append([x+dx[k], y+dy[k]])
                        b += 1

            big.append(b)

big.sort()

print(pieces)
for i in big:
    print(i)