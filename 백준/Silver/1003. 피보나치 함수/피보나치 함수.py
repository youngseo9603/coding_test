t = int(input())

zero = [1,0,1]
one = [0,1,1]

for i in range(t):

    n = int(input())
    if n > len(zero) - 1:
        for i in range(len(zero), n+1):
            zero.append(zero[i-1]+zero[i-2])
            one.append(one[i-1]+one[i-2])

    print(zero[n], one[n])
