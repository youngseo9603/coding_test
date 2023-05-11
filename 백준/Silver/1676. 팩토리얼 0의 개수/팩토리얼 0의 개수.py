n = int(input())

five = 0
for i in range(1, n+1):
    while(i%5==0):
        five += 1
        i = i/5

print(five)