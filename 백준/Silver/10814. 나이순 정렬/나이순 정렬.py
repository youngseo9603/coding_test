import sys

n = int(input())
information = []

for i in range(n):
    age, name = map(str, sys.stdin.readline().split())
    age = int(age)
    information.append((age, name))
information.sort(key = lambda x : x[0])

for i in range(n):
    print(information[i][0], information[i][1])