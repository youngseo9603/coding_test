def solution(s):
    
    s = s.replace("{","")
    s = s.replace("}","")

    num = []
    temp = []
    for i in s:
        if i != ",":
            temp.append(i)
        else:
            num.append("".join(temp))
            temp = []
    num.append("".join(temp))
    
    d = dict()
    for i in num:
        d[i] = d.get(i, 0) + 1

    
    answer = [0 for i in range(len(d))]
    
    for i in d:
        answer[d[i]-1] = int(i)
    
    answer.reverse()

    return answer