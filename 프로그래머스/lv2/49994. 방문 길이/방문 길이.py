def solution(dirs):
    
    command = {'U':(0, 1), 'D':(0, -1), 'L':(-1, 0), 'R':(1, 0)}
    x = 0
    y = 0
    visit = set()
    
    for i in (dirs):
        next_x = x + command[i][0]
        next_y = y + command[i][1]
        
        if -5 <= next_x <= 5 and -5 <= next_y <= 5:
            visit.add((x,y,next_x,next_y))
            visit.add((next_x,next_y,x,y))
            x = next_x
            y = next_y
        
    answer = len(visit) // 2
    
    return answer