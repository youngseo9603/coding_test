def solution(n):
    ans = 1
    
    while(n != 1):
        if n % 2 == 1:
            n = n - 1
            ans += 1
        else:
            n = n//2
    
    return ans