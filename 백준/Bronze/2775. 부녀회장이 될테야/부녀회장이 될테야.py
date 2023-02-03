t = int(input())

for i in range(t):
    k = int(input())
    n = int(input())

    temp = [[0 for j in range(n)] for i in range(k+1)]
    for i in range(n):
        temp[0][i] = i + 1

    for i in range(1,k+1):
        for j in range(n):
            if j != 0:
                temp[i][j] = temp[i-1][j] + temp[i][j-1]
            else:
                temp[i][j] = 1

    print(temp[k][n-1])


