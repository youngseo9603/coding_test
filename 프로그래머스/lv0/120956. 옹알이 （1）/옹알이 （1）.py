def solution(babbling):
    
    answer = 0
    
    
    for i in babbling:
        cnt = 0
        if "aya" in i:
            i = i.replace("aya"," ")
            cnt += 1
        if "ye" in i:
            i = i.replace("ye"," ")
            cnt += 1
        if "woo" in i:
            i = i.replace("woo"," ")
            cnt += 1
        if "ma" in i:
            i = i.replace("ma"," ")
            cnt += 1
        
        c = ""
        for j in range(cnt):
            c += " "
        
        if i == c:
            answer += 1
        
    return answer