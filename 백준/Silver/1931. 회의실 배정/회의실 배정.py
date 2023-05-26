import sys

n = int(input())

a = []
for i in range(n):
    a.append(list(map(int, sys.stdin.readline().split())))

a.sort(key=lambda x : (x[1], x[0]))

answer = []
answer.append(a[0])
for i in range(1, n):
    if a[i][0] >= answer[-1][1]:
        answer.append(a[i])

print(len(answer))