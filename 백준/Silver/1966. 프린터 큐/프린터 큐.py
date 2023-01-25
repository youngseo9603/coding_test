import sys

t = int(input())

for i in range(t):
    n , m = map(int, sys.stdin.readline().split())

    queue = list(map(int, sys.stdin.readline().split()))
    queue_order = [i for i in range(n)]

    cnt = 0
    while(m in queue_order):
        if queue[0] == max(queue):
            del queue_order[0]
            del queue[0]
            cnt += 1
        else:
            temp = queue[0]
            del queue[0]
            queue.append(temp)

            temp = queue_order[0]
            del queue_order[0]
            queue_order.append(temp)

    print(cnt)



