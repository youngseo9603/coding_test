from collections import deque

def solution(s):
    answer = [0, 0]
    
    ls = [int(i) for i in s]

    while(ls != [1]):
        answer[1] += ls.count(0)
        new_s = ls.count(1)
        ls = []
        while(new_s != 1):
            if new_s % 2 == 0:
                ls.append(0)
            else:
                ls.append(1)
            new_s = new_s // 2
        if new_s == 1:
            ls.append(1)
        ls.reverse()
        print(ls)
        answer[0] += 1
        
    return answer