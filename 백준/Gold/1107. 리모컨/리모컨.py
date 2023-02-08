import sys

n = int(input())
m = int(input())


m_list = list(map(str, sys.stdin.readline().split()))
cnt = abs(100-n)

for i in range(1000001):
    i = str(i)
    for j in range(len(i)):
        if i[j] in m_list:
            break
        elif j == len(i) - 1:
            cnt = min(cnt, abs(n - int(i)) + len(i))

print(cnt)
