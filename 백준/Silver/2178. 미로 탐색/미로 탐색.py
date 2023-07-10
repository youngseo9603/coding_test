n, m = map(int, input().split())

graph = [[0 for i in range(m)] for j in range(n)]
visited = [[0 for i in range(m)] for j in range(n)]
visited[0][0] = 1

for i in range(n):
    temp = input()
    for j in range(m):
        graph[i][j] = temp[j]

stack = []
stack.append([0,0,0])

dx = [0,0,-1,1]
dy = [1,-1,0,0]

answer = 0
while(stack):
    x, y, z = stack.pop(0)
    if x == n-1 and y == m-1:
        answer = z + 1
        break

    for i in range(4):
        if 0 <= dx[i] + x < n and 0 <= dy[i] + y < m and graph[dx[i] + x][dy[i] + y] == '1' and visited[dx[i] + x][dy[i] + y] == 0:
            stack.append([dx[i] + x , dy[i] + y, z+1])
            visited[dx[i] + x][dy[i] + y] = 1

print(answer)
