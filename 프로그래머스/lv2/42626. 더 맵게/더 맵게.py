from heapq import heappush, heappop, heapify

def solution(scoville, K):
    answer = 0
    
    heapify(scoville)
    
    while(scoville[0] < K):
        
        a = heappop(scoville)
        b = heappop(scoville)
        
        heappush(scoville, a + 2*b)
        answer += 1
        
        if len(scoville) == 1 and scoville[0] < K:
            answer = -1
            break
        
    return answer