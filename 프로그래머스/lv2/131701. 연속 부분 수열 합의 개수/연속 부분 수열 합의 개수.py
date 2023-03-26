def solution(elements):
    answer = 0
    
    d = dict()
    
    for i in range(len(elements)):
        d[elements[i]] = d.get(elements[i], 0) + 1
    
    for i in range(len(elements)):
        temp = elements[i]
        
        for j in range(1, len(elements)):
            temp += elements[(i+j)%len(elements)]
            d[temp] = d.get(temp, 0) + 1
    
    answer = len(d)
        
    return answer