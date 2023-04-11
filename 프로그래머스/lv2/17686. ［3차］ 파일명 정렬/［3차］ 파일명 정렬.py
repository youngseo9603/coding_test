def solution(files):
    answer = []
    files_l = [i for i in files]

    head_num_tail = [[i]for i in range(len(files))]
    for i in range(len(files)):
        files[i] = files[i].lower()
        temp = [[],[],[]]
        head = -1
        for j in range(len(files[i])):
            if head == -1 and ord(files[i][j]) >= 48 and ord(files[i][j]) <= 57:
                head = 0
                
            if head == 0 and (ord(files[i][j]) < 48 or ord(files[i][j]) > 57):
                head = 1
                
            if head == -1:
                temp[0].append(files[i][j])
            elif head == 0:
                temp[1].append(files[i][j])
            elif head == 1:
                temp[2].append(files[i][j])
        head_num_tail[i].append("".join(temp[0]))
        head_num_tail[i].append(int("".join(temp[1])))
        head_num_tail[i].append("".join(temp[2]))
        
    head_num_tail.sort(key = lambda x : (x[1], x[2]))
    
    for i in range(len(head_num_tail)):
        answer.append(files_l[head_num_tail[i][0]])
        
    
    return answer