def is_right(s):
    stack = []
    for j in range(len(s)):
        if s[j] == "[" or s[j] == "(" or s[j] == "{":
            stack.append(s[j])
        else:
            if stack == []:
                return False
            elif stack[len(stack)-1] == "[" and s[j] == "]":
                stack.pop()
            elif stack[len(stack)-1] == "(" and s[j] == ")":
                stack.pop()                   
            elif stack[len(stack)-1] == "{" and s[j] == "}":
                stack.pop()
            
    if stack == []:
        return True
    else:
        return False

def solution(s):
    answer = 0
    s = [i for i in s]
    
    for i in range(len(s)):
        s.append(s.pop(0))
        
        if is_right(s) == True:
            answer += 1

    
    return answer