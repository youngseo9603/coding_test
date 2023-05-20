import sys
from heapq import heapify, heappop, heappush

n = int(input())
l = list(map(int, sys.stdin.readline().split()))

heapify(l)

k = []
s = 0
for i in range(n):
    s += heappop(l)
    k.append(s)

print(sum(k))

