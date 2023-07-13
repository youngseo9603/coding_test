from collections import deque

t = int(input())

for test_case in range(t):
    func = input()
    p = int(input())
    arr = input().rstrip()[1:-1].split(",")
    d = deque(arr)
    error = 0
    flag = 0

    if p == 0:
        d = []

    for i in func:
        if i == "R":
            flag += 1
        elif i == "D":
            if len(d) < 1:
                error = 1
            else:
                if flag % 2 == 0:
                    d.popleft()
                else:
                    d.pop()

    if error == 1:
        print("error")
    else:
        if flag % 2 == 0:
            print("["+ ",".join(d) + "]")
        else:
            print("["+",".join(reversed(d))+ "]")
