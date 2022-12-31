a = input().upper()
set_a = set(a)

count = 0
for i in set_a:
    if a.count(i) > count:
        count = a.count(i)
        answer = i
    elif a.count(i) == count:
        answer = "?"

print(answer)