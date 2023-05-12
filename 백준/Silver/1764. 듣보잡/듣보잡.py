import sys

n, m = map(int, sys.stdin.readline().split())

d = dict()
for i in range(n):
    tmp = input()
    d[tmp] = d.get(tmp, 0) + 1

answer = []

for i in range(m):
    tmp = input()
    d[tmp] = d.get(tmp, 0) + 1
    if d[tmp] == 2:
        answer.append(tmp)

answer.sort()
print(len(answer))
for i in answer:
    print(i)