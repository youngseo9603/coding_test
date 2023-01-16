import sys

n, m = map(int, sys.stdin.readline().split())
tree = list(map(int, sys.stdin.readline().split()))

start = 1
end = max(tree)

while (start <= end):
    h = (start + end) // 2
    log = 0
    for i in range(n):
        if tree[i] > h:
            log = log + tree[i] - h

    if log >= m :
        start = h +1
    else :
        end = h - 1

print(end)