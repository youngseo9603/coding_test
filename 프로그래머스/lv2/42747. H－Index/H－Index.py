def solution(citations):
    answer = 0
    
    citations.sort()
    
    for idx, citation in enumerate(citations):
        if citation >= len(citations) - idx:
            return len(citations) - idx
    return 0
