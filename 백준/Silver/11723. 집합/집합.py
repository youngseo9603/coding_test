import sys

m = int(input())
s = set()

for i in range(m):
    temp = sys.stdin.readline().strip().split()

    if temp[0] == "all":
        s = set([j for j in range(1, 21)])
    elif temp[0] == "empty":
        s = set()

    else:
        func, x = temp[0], temp[1]
        x = int(x)
        if "add" == func:
            s.add(x)
        elif "remove" == func:
            s.discard(x)
        elif "check" == func:
            if x in s:
                print(1)
            else:
                print(0)
        elif "toggle" == func:
            if x in s:
                s.discard(x)
            else:
                s.add(x)


