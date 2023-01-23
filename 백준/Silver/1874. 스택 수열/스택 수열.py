n = int(input())
answer = []
stack =[]
flag = 0
cur = 1
for i in range(n):
    num = int(input())

    while(num >= cur):
        stack.append(cur)
        answer.append("+")
        cur += 1

    if stack[-1] == num:
        stack.pop()
        answer.append("-")

    else:
        flag = 1
        print("NO")
        break

if flag == 0:
    for i in answer:
        print(i)
