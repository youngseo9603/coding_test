import sys

t = int(input())

for i in range(t):

    vps = str(sys.stdin.readline().strip())

    for j in range(int(len(vps)/2)):
        vps = vps.replace('()','')

    if vps == "":
        print("YES")
    else:
        print("NO")