def solution(k, tangerine):
    answer = 0
    d = dict()
    for i in tangerine:
        d[i] = d.get(i, 0) + 1
    
    d = sorted(d.items())
    d.sort(key = lambda x: x[1], reverse = True)
    
    i = 0
    while(k>0):
        k -= d[i][1]
        i += 1
    
    answer = i
    return answer