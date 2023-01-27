from collections import deque

n = int(input())

card = deque([i+1 for i in range(n)])


while(len(card) > 1):

    card.popleft()
    card.append(card[0])
    card.popleft()

print(card[0])
