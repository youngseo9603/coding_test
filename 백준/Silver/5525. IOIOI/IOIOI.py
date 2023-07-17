import sys

n = int(input())
m = int(input())
s = input()
index = 0
answer = 0
count = 0
while(index < m-1):
    if s[index:index+3] == "IOI":
        index += 2
        count += 1
        if count == n:
            count -= 1
            answer += 1
    else:
        count = 0
        index += 1

print(answer)