n = int(input())

num = [0 for i in range (1001)]
num[1] = 1
num[2] = 2

if n >= 3:
    for i in range(3,n+1):
        num[i] = num[i-2] + num[i-1]

    print(num[n] % 10007)
else:
    print(num[n] % 10007)

