import sys

n, m = map(int, sys.stdin.readline().split())

node = [[] for i in range(n+1)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    node[a].append(b)
    node[b].append(a)

visited = [False] * (n+1)

def dfs(v):

    visited[v] = True
    for i in range(len(node[v])):
        if visited[node[v][i]] == False:
            visited[node[v][i]] = True
            dfs(node[v][i])


count = 0

for i in range(1, n+1):
    if visited[i] == True:
        continue
    else:
        dfs(i)
        count += 1

print(count)