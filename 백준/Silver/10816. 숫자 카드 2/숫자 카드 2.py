import sys

n = int(input())
card = list(map(int,sys.stdin.readline().split()))
m = int(input())
current_card = list(map(int,sys.stdin.readline().split()))
answer = []

card_dict = dict()
for i in range(n):
    card_dict[card[i]] = card_dict.get(card[i], 0) +1

for i in range(m):
    answer.append(str(card_dict.get(current_card[i],0)))

print(" ".join(answer))
