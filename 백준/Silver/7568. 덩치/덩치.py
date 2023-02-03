import sys

n = int(input())
w_h=[]

for i in range(n):
    w, h = map(int, sys.stdin.readline().split())
    w_h.append((w,h))

answer = [1 for i in range(n)]
for i in range(n):
    for j in range(n):
        if w_h[i][0] < w_h[j][0] and w_h[i][1] < w_h[j][1]:
            answer[i] += 1

for i in range(n):
    print(answer[i], end = " ")