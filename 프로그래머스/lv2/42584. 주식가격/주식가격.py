def solution(prices):

    answer = [0 for i in range(len(prices))]
    
    for i in range(len(prices)):
        current = prices[i]
        for j in range(i+1, len(prices)):
            if current <= prices[j]:
                answer[i] += 1
            else:
                answer[i] += 1
                break
    
    return answer