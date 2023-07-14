def solution(n, lost, reserve):
    answer = 0
    
    clothes = [1 for i in range(n+2)]
    for i in lost:
        clothes[i] -= 1
    for i in reserve:
        clothes[i] += 1
    
    print(clothes)
    
    for i in range(1, len(clothes)):
        if clothes[i] == 0 and clothes[i-1] == 2:
            clothes[i] += 1
            clothes[i-1] -= 1
        elif clothes[i] == 0 and clothes[i+1] == 2:
            clothes[i] += 1
            clothes[i+1] -= 1
    
    for i in clothes:
        if i == 0:
            answer += 1
    answer = n - answer
    
    return answer