
import sys

n = int(input())
q = []


for i in range(n):
    order = sys.stdin.readline().strip()

    if "push" in order:
        a,b = order.split()
        b = int(b)
        q.append(b)
    elif order == "pop":
        if len(q) > 0:
            print(q[0])
            q.pop(0)
        else:
            print(-1)
    elif order == "size":
        print(len(q))
    elif order == "empty":
        print(int(q==[]))
    elif order == "front":
        if len(q) > 0:
            print(q[0])
        else:
            print(-1)
    elif order == "back":
        if len(q) > 0:
            print(q[len(q)-1])
        else:
            print(-1)