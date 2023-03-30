from itertools import product
def solution(word):
    answer = 0
    
    words = []
    
    for i in range(1, 6):
        for j in product(['A', 'E', 'I', 'O', 'U'], repeat = i):
            words.append(''.join(list(j)))
            
    words.sort()
    
    return words.index(word) + 1