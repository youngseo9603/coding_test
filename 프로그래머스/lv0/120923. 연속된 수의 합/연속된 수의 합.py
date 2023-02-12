def solution(num, total):
    result = [0 for i in range(num)]
    
    result[ int((num-1)/2)] = int(total/num)
    for i in range( int((num-1)/2) + 1, num):
        result[i] = result[i-1]+1
    
    for i in range(int((num-1)/2), 0, -1):
        result[i-1] = result[i] - 1
    
    return(result)