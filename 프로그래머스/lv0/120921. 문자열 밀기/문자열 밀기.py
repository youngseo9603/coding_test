from collections import deque

def solution(A, B):
    
    answer = 0
    a = deque()
    b = deque()
    
    for i in range(len(A)):
        a.append(A[i])
        b.append(B[i])
    
    
    for i in range(len(A)):    
        print(a,b)
        if a==b:
            break
        
        a.appendleft(a[len(a)-1])
        a.pop()
        answer += 1
        
    if answer == len(A):
        answer = -1

    return answer