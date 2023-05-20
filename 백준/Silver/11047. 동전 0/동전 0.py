import sys

n, k = map(int, sys.stdin.readline().split())

a = []

for i in range(n):
    a.append(int(input()))

a.sort(reverse=True)
cnt = 0

for i in range(n):
    if k // a[i] >= 1:
        cnt += k//a[i]
        k -= a[i] * (k//a[i])

print(cnt)