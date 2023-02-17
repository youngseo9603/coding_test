from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    graph = [[-1 for i in range(m)] for j in range(n)]
    answer = 0
    q = deque()
    q.append([0,0])
    graph[0][0] = 1

    while(q):
        tx, ty = q.popleft()
        
        for i in range(4):
            if tx+dx[i]>=0 and tx+dx[i]<n and ty+dy[i]>=0 and ty+dy[i]<m and maps[tx+dx[i]][ty+dy[i]] == 1:
                if graph[tx+dx[i]][ty+dy[i]] == -1:
                    q.append([tx+dx[i], ty+dy[i]])
                    graph[tx+dx[i]][ty+dy[i]] = graph[tx][ty] + 1

    answer = graph[-1][-1]
    return answer