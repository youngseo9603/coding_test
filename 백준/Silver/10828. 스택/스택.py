import sys

n = int(input())

stack = []
for i in range(n):
    temp = sys.stdin.readline()

    if "push" in temp:
        a, k = map(str, temp.split())
        stack.append(int(k))
    elif "pop" in temp:
        if stack != []:
            print(stack.pop())
        else:
            print("-1")
    elif "size" in temp:
        print(len(stack))
    elif "empty" in temp:
        if stack == []:
            print("1")
        else:
            print("0")
    elif "top" in temp:
        if stack != []:
            print(stack[-1])
        else:
            print("-1")