k = int(input())
m = []
for i in range(k):
    m.append(int(input()))

i = 0
while (True):
    if m[i] == 0:
        m.pop(i)
        m.pop(i-1)
        i -= 2
    i += 1
    if 0 not in m:
        break

print(sum(m))