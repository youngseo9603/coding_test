
def check(n):
    answer = 0
    i = 1
    while True:
        answer = answer * 10 + 1
        answer %= n

        if answer == 0:
            break
        i += 1
    return i

while True:
    try:
        n = int(input())
        print(check(n))
    except:
        break