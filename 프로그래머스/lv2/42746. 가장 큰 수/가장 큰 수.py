def solution(numbers):
    answer = ''
    s_nums = []
    for i in numbers:
        s_nums.append(str(i))
    
    s_nums.sort(key = lambda x : x*3, reverse = True)
    
    answer = str(int("".join(s_nums)))
        
    return answer