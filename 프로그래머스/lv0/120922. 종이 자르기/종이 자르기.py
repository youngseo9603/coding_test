def solution(M, N):
    answer = 0
    
    b = max(M,N)
    s = min(M,N)
    
    for i in range(s-1):
        answer += 1
            
    for i in range(s):
        for j in range(b-1):
            answer += 1
    
    return answer