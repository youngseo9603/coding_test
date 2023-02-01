import sys

n = int(input())
xy = []


for i in range(n):
    x,y = map(int, sys.stdin.readline().split())
    xy.append((x,y))

xy.sort()

for i in xy:
    print(i[0], i[1])