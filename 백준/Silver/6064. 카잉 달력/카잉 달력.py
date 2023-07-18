test_case = int(input())

for t in range(test_case):
    m,n,x,y = map(int, input().split())

    answer = 1
    while x <= m*n:
        if (x-y) % n == 0:
            answer = x
            break
        x += m
        if x >= m*n:
            answer = -1
            break
            
    print(answer)

