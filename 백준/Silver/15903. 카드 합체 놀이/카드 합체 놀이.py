from heapq import heapify, heappop, heappush

n,m = map(int, input().split())
card = list(map(int, input().split()))
heapify(card)

for i in range(m):
    a = heappop(card)
    b = heappop(card)

    heappush(card, a+b)
    heappush(card, a+b)

answer = 0
for i in card:
    answer+=i

print(answer)