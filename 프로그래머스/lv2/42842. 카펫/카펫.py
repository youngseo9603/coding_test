def solution(brown, yellow):
    answer = []
    
    for i in range(1, brown+yellow+1):
        if (brown+yellow)%i == 0:
            a = (brown+yellow)//i
            if a >= i:
                if 2*a + 2*i == brown + 4:
                    return[a, i]
            
    
    return answer