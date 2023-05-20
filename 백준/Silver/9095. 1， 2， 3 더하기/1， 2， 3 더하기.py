from itertools import product

a = [1,2,3]

n = int(input())

for i in range(n):
    num = int(input())
    k = []
    answer = 0
    for j in range(num):
        k = list(product(a, repeat = j))
        for z in k:
            if sum(z) == num:
                answer += 1
    print(answer+1)
