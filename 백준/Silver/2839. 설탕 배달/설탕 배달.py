n = int(input())

answer = -1
for i in range(n//5 + 1):
    if ( (n - 5*i) % 3 == 0 ):
        answer = i + (n-5*i)//3

print(answer)