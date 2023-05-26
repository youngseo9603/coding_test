import sys
from heapq import heapify, heappush, heappop

n = int(sys.stdin.readline())
h = []
heapify(h)

for i in range(n):
    a = int(sys.stdin.readline())
    if a != 0:
        heappush(h, a)
    elif len(h) == 0:
        print(0)
    else:
        print(heappop(h))
