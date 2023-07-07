import sys

n, m = map(int, sys.stdin.readline().split())

num = list(map(int, sys.stdin.readline().split()))

sum_num = [0]
cur = 0

for i in num:
    cur += i
    sum_num.append(cur)

for i in range(m):
    start, end = map(int, sys.stdin.readline().split())

    print(sum_num[end] - sum_num[start-1])

