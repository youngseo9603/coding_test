-- 코드를 입력하세요
SELECT C.APNT_NO, A.PT_NAME, A.PT_NO, C.MCDP_CD, B.DR_NAME, C.APNT_YMD
FROM (APPOINTMENT AS C LEFT JOIN PATIENT AS A
ON C.PT_NO = A.PT_NO) LEFT JOIN DOCTOR AS B
ON C.MDDR_ID = B.DR_ID
WHERE C.APNT_YMD LIKE '2022-04-13%' 
    AND C.APNT_CNCL_YN LIKE 'N'
    AND C.MCDP_CD LIKE 'CS'
ORDER BY C.APNT_YMD