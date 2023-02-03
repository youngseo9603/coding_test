n = int(input())
x_y = []

for i in range(n):
    x, y = map(int, input().split())
    x_y.append((x,y))

x_y.sort()
x_y.sort(key = lambda x: x[1])

for i in range(n):
    print(x_y[i][0], x_y[i][1])
