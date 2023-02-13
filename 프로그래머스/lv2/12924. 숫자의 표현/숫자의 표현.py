def solution(n):
    
    answer = 1
    sum = 0
    for i in range(1, int(n/2)+1):
        temp = i
        
        while(sum < n):
            sum += temp
            temp += 1

        if sum == n:
            answer += 1
            sum = 0
        else:
            sum = 0
    
    return answer