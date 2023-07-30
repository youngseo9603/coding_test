from itertools import product

n, m = map(int, input().split())
nums = [i+1 for i in range(n)]
answer = list(product(nums, repeat=m))

for i in range(len(answer)):
    for j in range(len(answer[i])):
        print(answer[i][j], end=" ")
    print()
        