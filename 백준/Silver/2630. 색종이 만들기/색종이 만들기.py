import sys

n = int(input())
paper = []
for i in range(n):
    paper.append(list(map(int, sys.stdin.readline().split())))

answer = {1:0, 0:0}

def check(n, r, c):
    curr = paper[r][c]

    for i in range(r,r+n):
        for j in range(c,c+n):
            if curr != paper[i][j]:
                n = n//2
                check(n, r, c)
                check(n, r+n, c)
                check(n, r, c+n)
                check(n, r+n, c+n)
                return

    answer[curr] += 1
    return

check(n,0,0)

print(answer[0])
print(answer[1])