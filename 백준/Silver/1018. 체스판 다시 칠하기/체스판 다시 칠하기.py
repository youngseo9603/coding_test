import sys

n, m = map(int, sys.stdin.readline().split())

test = [[0 for i in range(m-7)] for j in range(n-7)]

chess = [["0" for i in range(m)] for j in range(n)]

for i in range(n):
    temp = sys.stdin.readline()
    for j in range(m):
        chess[i][j] = temp[j]

w_right_chess = [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']]
b_right_chess = [['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                 ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                 ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]

for i in range(n-7):
    for j in range(m-7):
        w_count = 0
        b_count = 0
        for a in range(8):
            for b in range(8):
                if chess[a+i][b+j] != w_right_chess[a][b]:
                    w_count += 1
                if chess[a+i][b+j] != b_right_chess[a][b]:
                    b_count += 1
        test[i][j] = min(w_count,b_count)

answer = test[0][0]
for min_value in test:
    answer = min(min(min_value), answer)

print(answer)