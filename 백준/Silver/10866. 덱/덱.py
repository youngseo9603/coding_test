import sys
from collections import deque

n = int(input())
d = deque()

for i in range(n):
    order = sys.stdin.readline().strip()

    if "push_front" in order:
        a,b = order.split()
        b = int(b)
        d.appendleft(b)
    elif "push_back" in order:
        a,b = order.split()
        b = int(b)
        d.append(b)
    elif "pop_front" in order:
        if len(d)>0:
            print(d.popleft())
        else:
            print(-1)
    elif "pop_back" in order:
        if len(d) > 0:
            print(d.pop())
        else:
            print(-1)
    elif "size" in order:
        print(len(d))
    elif "empty" in order:
        if len(d) > 0:
            print(0)
        else:
            print(1)
    elif "front" in order:
        if len(d) > 0:
            print(d[0])
        else:
            print(-1)
    elif "back" in order:
        if len(d) > 0:
            print(d[len(d)-1])
        else:
            print(-1)

