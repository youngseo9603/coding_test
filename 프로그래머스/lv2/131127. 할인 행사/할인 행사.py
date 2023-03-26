def solution(want, number, discount):
    answer = 0
    
    d = dict()
    for i in range(len(want)):
        d[want[i]] = number[i]
    
    for i in range(len(discount) - sum(number)+1):
        temp = d.copy()
        for j in range(sum(number)):
            temp[discount[i+j]] = temp.get(discount[i+j], 0) - 1
        
        cnt = 0
        for i in temp:
            if temp[i] != 0:
                cnt += 1
        
        if cnt == 0:
            answer += 1
    
    return answer