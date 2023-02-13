def solution(s):
    
    ls = []
    for i in range(len(s)):
        if s[i] == '(':
            ls.append(s[i])
        else:
            if ls == []:
                return False
            else:
                ls.pop()
    
    return ls == []