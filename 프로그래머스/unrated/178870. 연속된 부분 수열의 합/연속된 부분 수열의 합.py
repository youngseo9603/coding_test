def solution(sequence, k):
    answer = []
    
    sum = 0
    s = -1
    l = 0
    
    while(True):
        if sum < k:
            s += 1
            if s >= len(sequence):
                break
            sum += sequence[s]
        else:
            sum -= sequence[l]
            if l >= len(sequence):
                break
            l += 1
            
        if sum == k:
            answer.append([min(s,l), max(s,l)])

    w = [answer[0][0], answer[0][1]]
    
    for i in answer:
        if w[1] - w[0] > i[1] - i[0]:
            w[1] = i[1]
            w[0] = i[0]
            
    
    return w