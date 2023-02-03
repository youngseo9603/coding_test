l = int(input())
w = input()

sum = 0
for i in range(l):
    sum += (ord(w[i])-96) * (31**i)
print(sum)