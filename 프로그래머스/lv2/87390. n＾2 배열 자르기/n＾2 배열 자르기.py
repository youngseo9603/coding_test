def solution(n, left, right):
    answer = []
    
    start = [left//n, left%n]
    end = [right//n, right % n]
    
    temp = [left//n, left%n]
    while(temp != end):
        answer.append(max(temp)+1)
        temp = [temp[0], temp[1]+1]
        if temp[1] == n:
            temp = [temp[0]+1, 0]
    
    answer.append(max(temp)+1)
    
    return answer