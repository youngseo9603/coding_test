import sys

n, m = map(int, sys.stdin.readline().split())
d = dict()

for i in range(n):
    site, password = map(str, sys.stdin.readline().split())
    d[site] = password

for i in range(m):
    k = input()
    print(d[k])
