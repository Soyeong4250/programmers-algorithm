-- 코드를 입력하세요
SELECT *
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H, (SELECT C.CAR_ID, P.DISCOUNT_RATE
                                    FROM CAR_RENTAL_COMPANY_CAR C, CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
                                     WHERE C.CAR_TYPE = P.CAR_TYPE 
                                     AND C.CAR_TYPE REGEXP('세단|SUV') 
                                     AND P.DURATION_TYPE REGEXP ('30일 이상|90일 이상')) P