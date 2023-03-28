def solution(skill, skill_trees):
    answer = 0
    
    
    for i in skill_trees:
        skill_state = 0
        skill_trees_state = 0
        for j in range(len(i)):
            if i[j] in skill and i[j] != skill[skill_state]:
                skill_trees_state = -1
                break
            elif i[j] not in skill:
                continue
            else:
                skill_state += 1
                skill_state = skill_state % len(skill)
        
        if skill_trees_state == 0:
            answer += 1
        
    
    return answer