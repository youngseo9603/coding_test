import sys

a, b = map(int, sys.stdin.readline().split())

m = min(a,b)
while(m > 0):
    if a%m == 0 and b%m == 0:
        print(m)
        break
    m -= 1

m = max(a,b)
while(True):
    if m%a == 0 and m%b == 0:
        print(m)
        break
    m += 1