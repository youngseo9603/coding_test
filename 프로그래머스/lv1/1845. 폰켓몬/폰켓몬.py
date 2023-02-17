def solution(nums):
    answer = 0
    d = dict()
    
    n = len(nums)//2
    
    for i in nums:
        d[i] = d.get(i,0) + 1
    
    if n < len(d):
        answer = n
    else:
        answer = len(d)
    
    return answer