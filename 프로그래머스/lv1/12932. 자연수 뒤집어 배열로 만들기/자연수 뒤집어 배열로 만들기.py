def solution(n):
    
    n = str(n)
    answer = []
    
    for i in n:
        answer.append(int(i))
        
    answer.reverse()
    
    return answer