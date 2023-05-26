
a = input().split("-")

for i in range(len(a)):
    if "+" in a[i]:
        k = map(int, a[i].split("+"))
        a[i] = sum(k)
    else:
        a[i] = int(a[i])

answer = a[0]
for i in range(1, len(a)):
    answer -= a[i]

print(answer)