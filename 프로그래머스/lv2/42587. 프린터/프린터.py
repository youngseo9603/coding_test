from collections import deque

def solution(priorities, location):
    answer = 0
    d = deque()
    for i in range(len(priorities)):
        d.append([priorities[i], i])
    
    pri = []
    
    while(len(d)>1):
        k = d.popleft()
        if k[0] >= max(d)[0]:
            pri.append(k)
        else:
            d.append(k)
    pri.append(d[0])    
    
    for i in range(len(pri)):
        if pri[i][1] == location:
            print(i)
            return i+1
