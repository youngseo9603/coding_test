import math
def solution(n,a,b):
    answer = 0

    while(a!=b):
        a = math.ceil(a/2)
        b = math.ceil(b/2)
        answer += 1
        print(a,b)
    

    return answer