def solution(participant, completion):
    answer = ''
    d = dict()
    
    for i in participant:
        d[i] = d.get(i, 0) + 1
    
    for i in completion:
        d[i] = d.get(i) - 1
    
    for i in d:
        if d[i] == 1:
            answer = i
    return answer