import sys

computer = [i for i in range(int(input()))]
n = int(input())

link = []
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    link.append([a,b])

virus = [1]
stack = [1]
while(stack):
    k = stack.pop()
    for i in link:
        if k in i:
            a = i[0]
            b = i[1]
            if a not in virus:
                virus.append(a)
                stack.append(a)
            if b not in virus:
                virus.append(b)
                stack.append(b)

print(len(virus) - 1)