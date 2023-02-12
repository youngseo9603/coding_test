def solution(my_string):
    my_string = my_string.lower()
    a = []
    for i in my_string:
        a.append(i)
    a.sort()
    answer = "".join(a)
    return answer