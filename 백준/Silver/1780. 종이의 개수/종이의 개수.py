
n = int(input())

paper = []
for i in range(n):
    paper.append(list(map(int, input().split())))

answer = {-1:0, 0:0, 1:0}

def check(r, c, n):

    curr = paper[r][c]

    for i in range(r, r+n):
        for j in range(c, c+n):
            if paper[i][j] != curr:
                next = n//3
                check(r, c, next)
                check(r+next, c, next)
                check(r+2*next, c, next)
                check(r, c+next, next)
                check(r, c+2*next, next)
                check(r+next, c+next, next)
                check(r+next, c+2*next, next)
                check(r+2*next, c+next, next)
                check(r+2*next, c+2*next, next)
                return
    answer[curr] += 1
    return

check(0,0,n)

for i in answer.values():
    print(i)