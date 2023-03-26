from itertools import permutations

def solution(k, dungeons):
    answer = -1
    dungeons_len = len(dungeons)
    dungeons_list = [i for i in range(dungeons_len)]
    dungeons_permutation = list(permutations(dungeons_list,dungeons_len))
    
    for i in (dungeons_permutation):
        
        count = k
        cnt = 0
        ans = 0
        while(count >= 0 and cnt < dungeons_len):
            
            if count >= dungeons[i[cnt]][0]:
                count -= dungeons[i[cnt]][1]
                ans += 1
            
            cnt += 1
             
        answer = max(answer, ans)
        
    
    return answer