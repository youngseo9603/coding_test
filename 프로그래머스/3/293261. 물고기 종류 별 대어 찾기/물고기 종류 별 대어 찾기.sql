-- 코드를 작성해주세요
SELECT B.ID, A.FISH_NAME, B.LENGTH AS LENGTH
FROM FISH_NAME_INFO AS A LEFT JOIN FISH_INFO AS B ON A.FISH_TYPE = B.FISH_TYPE
WHERE (B.FISH_TYPE, B.LENGTH) IN (
        SELECT FISH_TYPE, MAX(LENGTH)
        FROM FISH_INFO
        GROUP BY FISH_TYPE
    )
ORDER BY B.ID