import sys

n,m = map(int, sys.stdin.readline().split())

d = dict()
for i in range(n):
    temp = input()
    d[str(i+1)] = temp
    d[temp] = i+1

for j in range(m):
    print(d[input()])