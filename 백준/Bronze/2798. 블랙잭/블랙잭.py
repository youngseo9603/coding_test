import sys
from itertools import permutations

n, m = map(int, sys.stdin.readline().split())
card = list(map(int, sys.stdin.readline().split()))

a = list(permutations(card,3))


t = m

for i in range(len(a)):
    if sum(a[i]) <= m and m - sum(a[i]) < t:
        t = m - sum(a[i])

print(m - t)
