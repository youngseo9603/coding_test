import sys

t = int(input())

for i in range(t):
    h, w, n = map(int, sys.stdin.readline().split())
    current_h = 0
    current_w = 1
    for i in range(n):
        if current_h < h:
            current_h += 1
        else:
            current_w +=1
            current_h = 1

    print((current_h)*100 + (current_w))