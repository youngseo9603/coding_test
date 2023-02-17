import math

def solution(progresses, speeds):
    answer = []
    n = len(progresses)
    days = []
    for i in range(n):
        days.append(math.ceil((100-progresses[i])/speeds[i]))

    cnt = 1
    s = days[0]
    n = 1
    while(n != len(days)):
        
        print(s, days[n])
        if s >= days[n]:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            s = days[n]
        n += 1
    answer.append(cnt)

            
    return answer