import sys

n = int(input())

a = list(map(int, sys.stdin.readline().split()))

print(min(a), max(a))