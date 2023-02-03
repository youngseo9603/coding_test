from collections import Counter

n = int(input())
num = []
for i in range(n):
    num.append(int(input()))

print(round(sum(num)/n))
num.sort()
print(num[n//2])
if len(num) > 1:
    [a, b] = Counter(num).most_common(2)
    if (a[1] == b[1]):
        print(b[0])
    else:
        print(a[0])
else:
    print(num[0])
print(max(num)-min(num))