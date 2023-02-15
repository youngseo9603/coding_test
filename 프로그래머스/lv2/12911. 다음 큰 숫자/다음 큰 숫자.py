def solution(n):
    answer = n
    binary_n = []
    binary_answer = []
    
    while(n != 0 and n != 1):
        if n % 2 == 1:
            binary_n.append(1)
        else:
            binary_n.append(0)
        n = n//2     
    binary_n.append(n)
    
    
    while(True):
        answer += 1 
        n = answer
        while(n != 0 and n != 1):
            if n % 2 == 1:
                binary_answer.append(1)
            else:
                binary_answer.append(0)
            n = n//2  
        binary_answer.append(n)
        
        if binary_answer.count(1) == binary_n.count(1):
            print(binary_answer)
            break
        else:
            binary_answer.clear()
        
    
    return answer