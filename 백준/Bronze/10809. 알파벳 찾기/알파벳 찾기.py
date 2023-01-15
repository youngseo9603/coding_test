
word = list(input())
abc = "abcdefghijklmnopqrstuvwxyz"

for i in abc:
    if i in word:
        print(word.index(i), end = ' ')
    else:
        print(-1, end = ' ')

