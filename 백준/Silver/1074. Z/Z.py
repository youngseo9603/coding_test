import sys

n, r, c = map(int, sys.stdin.readline().split())

h = 2**n
start = 0
end = h*h-1

while(True):

    if h < 4:
        if r == 0 and c == 0:
            print(int(start))
        elif r == 0 and c == 1:
            print(int(start + 1))
        elif r == 1 and c == 0:
            print(int(start + 2))
        elif r == 1 and c == 1:
            print(int(start + 3))
        break

    if r < h/2 and c < h/2 :
        end = start + (h * h / 4) - 1
    elif r < h/2 and c >= h/2 :
        start = start + (h * h / 4)
        end = start + (h * h / 4) - 1
        c -= h / 2
    elif r >= h / 2 and c < h / 2:
        start = start + (h * h / 2)
        end = start + (h * h / 4) - 1
        r -= h / 2

    else:
        start = start + (3 * h * h / 4)
        r -= h / 2
        c -= h / 2

    h = h/2
