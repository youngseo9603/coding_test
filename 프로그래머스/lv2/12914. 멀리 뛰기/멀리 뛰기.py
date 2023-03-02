def solution(n):
    answer = 0
    
    if n < 3:
        return n
    
    dp = [0 for i in range(n+1)]
    dp[0] = 1
    dp[1] = 2
    dp[2] = 3
    
    for i in range(3, n):
        dp[i] = dp[i-2] + dp[i-1]
    
    answer = dp[n-1]%1234567
    return answer