import sys

n, m, b = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = sys.maxsize
idx = 0

# 0층부터 256층까지 반복
for target in range(257):
    max_target, min_target = 0, 0

    # 반복문을 통해 블록을 확인
    for i in range(n):
        for j in range(m):

            # 블록이 층수보다 더 크면
            if graph[i][j] >= target:
                max_target += graph[i][j] - target

            # 블록이 층수보다 더 작으면
            else:
                min_target += target - graph[i][j]

    # 블록을 뺀 것과 원래 있던 블록의 합과 블록을 더한 값을 비교
    # 블록을 뺀 것과 원래 있던 블록의 합이 더 커야 층을 만들 수 있음.
    if max_target + b >= min_target:
        # 시간 초를 구하고 최저 시간과 비교 
        if min_target + (max_target * 2) <= answer:
        	# 0부터 256층까지 비교하므로 업데이트 될수록 고층의 최저시간
            answer = min_target + (max_target * 2) # 최저 시간
            idx = target # 층수

print(answer, idx)