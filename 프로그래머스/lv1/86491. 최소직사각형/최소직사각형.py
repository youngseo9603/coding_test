def solution(sizes):
    answer = 0
    
    for i in range(len(sizes)):
        sizes[i].sort()
        
    a = max(sizes, key = lambda x : x[0])[0]
    b = max(sizes, key = lambda x : x[1])[1]
    
    answer = a*b
    
    return answer