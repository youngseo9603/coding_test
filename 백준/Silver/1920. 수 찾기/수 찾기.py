import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
a.sort()

m = int(sys.stdin.readline())
k = list(map(int, sys.stdin.readline().split()))

for i in k:
    start = 0
    end = len(a) - 1
    while(start <= end):
        mid = (start + end)//2
        if(a[mid] > i):
            end = mid -1
        else:
            start = mid + 1
    print(int(a[end] == i))

