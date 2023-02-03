import sys

n = sys.stdin.readline().strip()
answer = []

for i in range(int(n)):
    num = []
    for j in range(len(str(i))):
        num.append(int(str(i)[j]))

    if sum(num) + i == int(n):
        answer.append(i)
        break

if len(answer) == 0:
    print(0)
else:
    print(answer[0])