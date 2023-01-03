N = int(input())
dict_N = {}

for i in range(N):
    temp = int(input())
    if temp not in dict_N:
        dict_N[temp] = 1
    else:
        dict_N[temp] += 1


dict = sorted(dict_N.items(),key = lambda x: (-x[1],x[0]))
print(dict[0][0])