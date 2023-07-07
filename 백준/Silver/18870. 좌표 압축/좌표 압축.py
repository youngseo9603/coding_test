import sys

n = sys.stdin.readline()

t = list(map(int, sys.stdin.readline().split()))

x = sorted(t)

d = dict()

cur = 0
for i in range(len(x)):
    d[x[i]] = d.get(x[i], -1)
    if d[x[i]] == -1:
        d[x[i]] = cur
        cur += 1
    else:
        continue

for i in t:
    print(d[i], end = " ")
