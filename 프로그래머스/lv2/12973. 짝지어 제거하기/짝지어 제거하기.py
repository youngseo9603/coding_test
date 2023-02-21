from collections import deque

def solution(s):
    
    answer = 0
    stack = []
    
    for i in s:
        if len(stack) == 0:
            stack.append(i)
        elif stack[-1] == i:
            stack.pop()
        else:
            stack.append(i)

    
    if stack == []:
        answer = 1
    else:
        answer = 0
    
    return answer

