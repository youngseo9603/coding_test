-- 코드를 작성해주세요
SELECT A.ID, IFNULL(B.CHILD_COUNT, 0) AS CHILD_COUNT
FROM ECOLI_DATA AS A LEFT JOIN 
    (SELECT PARENT_ID AS ID, COUNT(*) AS CHILD_COUNT
    FROM ECOLI_DATA 
    GROUP BY PARENT_ID
    HAVING ID IS NOT NULL) AS B
ON A.ID = B.ID
ORDER BY A.ID