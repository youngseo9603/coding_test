import sys
from itertools import combinations

n, k = map(int, sys.stdin.readline().split())

n_list = [i for i in range(n)]
a = list(combinations(n_list,k))
print(len(a))