import sys
from collections import deque

def bfs():
    queue = deque()
    queue.append(n)
    while(queue):
        v = queue.popleft()
        if v == k:
            print(dist[v])
            break
        for nv in (v-1, v+1, 2*v):
            if 0<= nv <= 100000 and not dist[nv]:
                dist[nv] = dist[v] +1
                queue.append(nv)

dist = [0 for i in range(100001)]
n, k = map(int, sys.stdin.readline().split())

bfs()
