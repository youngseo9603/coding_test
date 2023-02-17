def solution(clothes):
    answer = 1
    
    d = dict()
    
    for i in clothes:
        d[i[1]] = d.get(i[1], 0) + 1
    
    temp = []
    
    for i in d:
        answer *= d[i]+1
  
    return answer-1