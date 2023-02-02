import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
n_array = deque([])
for i in range(n):
    n_array.append(i+1)
answer = deque([])

while n_array:
    for i in range(k-1):
        n_array.append(n_array[0])
        n_array.popleft()

    answer.append(str(n_array.popleft()))

print("<", end = "")
for i in range(len(answer)-1):
    print(answer[i], end = ", ")

print(answer[len(answer)-1], end = ">")