from itertools import permutations
def solution(numbers):
    answer = 0
    
    nums = []
    
    for i in range(1, len(numbers)+1):
        temp = list(permutations(numbers,i))
        nums += temp
    
    per = []
    for i in range(len(nums)):
        k = "".join(nums[i])
        per.append(int(k))
    

    per = set(per)

    for i in per:
        if i > 1:
            cnt = 0
            for j in range(2,int(i**0.5)+1):
                if i%j == 0:
                    cnt = 1
                    break
            if cnt == 0:
                answer += 1
    
    
    return answer