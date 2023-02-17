from collections import deque

def solution(numbers, target): 
    answer = 0
    
    q = deque()
    n = len(numbers)
    q.append([numbers[0],0])
    q.append([-numbers[0],0])
    
    while(q):
        temp, idx = q.popleft()
        idx += 1
        if idx < n:
            q.append([temp+numbers[idx], idx])
            q.append([temp-numbers[idx], idx])
            
        else:
            if temp == target:
                answer += 1

    return answer