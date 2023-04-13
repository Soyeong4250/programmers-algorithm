## SQL 문법 정리

### 목차

- [SELECT 문](#select-문)
  * [날짜 포맷 변경](#날짜-포맷-변경)
    + [DATE_FORMAT(날짜 포맷 변경할 데이터, '날짜 포맷')](#date_format날짜-포맷-변경할-데이터-날짜-포맷)
  * [NULL 처리(IS NOT NULL, IFNULL, CASE, COALESCE)](#null-처리is-not-null-ifnull-case-coalesce)
    + [IFNULL(데이터 컬럼, 'NULL일 경우 표시할 데이터')](#ifnull데이터-컬럼-null일-경우-표시할-데이터)
    + [CASE WHEN 조건식 THEN 식](#case-when-조건식-then-식)
    + [COALESCE(컬럼명1, 컬럼명2, 컬럼명3)](#coalesce컬럼명1-컬럼명2-컬럼명3)
  * [반올림과 버림](#반올림과-버림)
    + [ROUND(숫자, 반올림할 자릿수)](#round숫자-반올림할-자릿수)
    + [TRUNCATE(숫자, 버릴 자릿수)](#truncate숫자-버릴-자릿수)
  * [LIMIT(시작 인덱스, 데이터를 조회할 개수)을 이용한 정렬](#limit시작-인덱스-데이터를-조회할-개수을-이용한-정렬)
  * [UNION, UNION ALL](#UNION-UNION-ALL)
    * [UNION](#UNION)
    * [UNION ALL](#UNION-ALL)
    * [테이블별로 정렬한 후 합치기](#테이블별로-정렬한-후-합치기)
- [SUM, MAX, MIN](#SUM-MAX-MIN)
  - [최댓값을 가진 or 최솟값을 가지는 데이터 조회](#최댓값을-가진-or-최솟값을-가지는-데이터-조회)
  - [집계함수](#집계함수)
    + [COUNT()](#count)
    + [DISTINCT()](#distinct)
    + [SUM()](#sum)
    + [AVG()](#avg)
    + [MAX() / MIN()](#max--min)

<br />

<br />

---

### MySQL 문법에서 반드시 알아야 하는 것

### 쿼리문의 실행 순서

⭐ FROM - ON - JOIN - WHERE - GROUP BY - HAVING - SELECT - DISTINCT - ORDER BY 

### 쿼리문의 작성 순서

SELECT - FROM - WHERE - GROUP BY - HAVING - OREDER BY

<br />

<br />

---

### SELECT 문

#### 날짜 포맷 변경

##### DATE_FORMAT(날짜 포맷 변경할 데이터, '날짜 포맷')

1️⃣ YYYY/mm/dd 포맷

```sql
SELECT DATE_FORMAT('19920212', '%Y/%m/%d')
```

2️⃣ YYYY-mm-dd 포맷

```sql
SELECT DATE_FORMAT('19929212', '%Y-%m-%d')
```

3️⃣ 영어로 표현

```sql
SELECT DATE_FORMAT('19920212', '%W %M %Y')
```

4️⃣ 포맷 형태

| 지정값 |       구분       |                           표시형식                           |
| :----: | :--------------: | :----------------------------------------------------------: |
|   %Y   |        연        |                          4자리 연도                          |
|   %y   |        연        |                          2자리 연도                          |
|   %m   |        월        |                        2자리 (00-12)                         |
|   %c   |        월        |                1자리, 10보다 작을경우 (1-12)                 |
|   %M   |        월        |                   이름(January, February…)                   |
|   %b   |        월        |                     줄인 이름(Jan, Feb…)                     |
|   %d   |        일        |                        2자리 (00-31)                         |
|   %e   |        일        |                1자리, 10보다 작을경우 (0-31)                 |
|   %D   |        일        |                          1st, 2nd…                           |
|   %H   |        시        |                     24시간 형식 (00-23)                      |
|   %h   |        시        |                     12시간 형식 (01-12)                      |
|   %I   |        시        |                     12시간 형식 (01-13)                      |
|   %k   |        시        |          24시간 형식, 10보다 작을경우 한자리 (0-23)          |
|   %l   |        시        |          12시간 형식, 10보다 작을경우 한자리 (1-12)          |
|   %i   |        분        |                        2자리 (00-59)                         |
|   %S   |        초        |                        2자리 (00-59)                         |
|   %s   |        초        |                        2자리 (00-59)                         |
|   %f   |    마이크로초    |                        100만분의 1초                         |
|   %p   |    오전/오후     |                            AM/PM                             |
|   %T   |      시분초      |                    24시간 형식 (hh:mm:ss)                    |
|   %r   | 시분초 오전/오후 |                 12시간 형식 (hh:mm:ss AM/PM)                 |
|   %j   |        일        |             그해의 몇번째 일인지 표시 (001-366)              |
|   %w   |        일        |        그주의 몇번째 일인지 표시 (0=일요일, 6=토요일)        |
|   %W   |        주        |                    이름(Monday,Tuesday…)                     |
|   %a   |        주        |                     줄인 이름(Mon,Tue…)                      |
|   %U   |        주        |   그해의 몇번째 주인지 표시 (00-53) 일요일이 주의 첫번째일   |
|   %u   |        주        |   그해의 몇번째 주인지 표시 (00-54) 월요일이 주의 첫번째일   |
|   %X   |        연        |           그주가 시작된 해을 표시, %V와 같이 사용            |
|   %x   |        연        |           그주가 시작된 해을 표시, %v와 같이 사용            |
|   %V   |        주        | 그주가 시작된 해의 몇번째 주인지 표시 (01-53) 일요일이 주의 첫번째일 %X 와 함께사용 |
|   %v   |        주        | 그주가 시작된 해의 몇번째 주인지 표시 (01-53) 월요일이 주의 첫번째일 %x 와 함께사용 |

<br />

#### NULL 처리(IS NOT NULL, IFNULL, CASE, COALESCE)

##### IFNULL(데이터 컬럼, 'NULL일 경우 표시할 데이터')

아래는 '12세 이하인 여자 환자 목록 출력하기'의 쿼리문으로, 전화번호(TLNO)가 없는 경우 'NONE'으로 출력시키는 SELECT 문이다.

```sql
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE')
FROM PATIENT
WHERE GEND_CD = 'W' AND AGE <= 12
ORDER BY AGE DESC, PT_NAME
```

##### CASE WHEN 조건식 THEN 식

Java의 Switch문과 같은 역할로, 해당 컬럼 값 조건에 맞게 Column 값을 변환할 때 사용하는 함수

```sql
SELECT
	CASE
		WHEN NAME IS NULL THEN "No name"
		ELSE NAME
    END AS NAME
FROM ANIMAL_INS
```

##### COALESCE(컬럼명1, 컬럼명2, 컬럼명3)

지정한 표현식들 중 NULL이 아닌 첫 번째 값을 반환하며, 표현식이 모두 NULL일 경우엔 결과도 NULL 을 반환한다.

해당 쿼리문은 모든 DBMS에서 사용 가능하다.

```sql
-- NULL 처리 상황
SELECT COALESCE(컬럼명1, 컬럼명1이 NULL인 경우 대체할 값)
FROM 테이블명

-- 배타적 OR 관계 열
-- 컬럼1~4 중 처음으로 만나는 NULL이 아닌 컬럼을 출력 
SELECT COALESCE(컬럼명1, 컬럼명2, 컬럼명3, 컬럼명4)
FROM 테이블명
```

<br />

#### 반올림과 버림

##### ROUND(숫자, 반올림할 자릿수)

반올림할 자릿수 + 1 자릿수에서 반올림해주는 함수로, 숫자를 명시하지 않을 경우 소수 첫째자리에서 반올림을 하게 된다.

```SQL
SELECT ROUND(3.14159265358)
FROM MATH
```

👉 3

```SQL
SELECT ROUND(3.14159265358, 4)
FROM MATH
```

👉 3.1416

소수점 위의 자릿수에서 반올림해주기 위해서는 다음과 같이 작성하면 된다

```mysql
SELECT ROUND(213.14159265358, -2)
FROM MATH
```

👉 210 (10의 자리수에서 반올림)

##### TRUNCATE(숫자, 버릴 자릿수)

버릴 자릿수 아래로 버리는 함수로, ROUND() 함수와 달리 반드시 버릴 자릿수를 명시해 주어야 한다.

```SQL
SELECT ROUND(3.14159265358, 4)
FROM MATH
```

👉 3.1415

<br />

#### LIMIT(시작 인덱스, 데이터를 조회할 개수)을 이용한 정렬

정렬된 데이터에서 가장 앞(0번째)부터 3개까지의 데이터만 조회하는 SQL문

```sql
SELECT *
FROM 테이블명
ORDER BY 기준컬럼 (DESC / ASC) LIMIT 3 
```

아래는 '상위 n개 레코드'의 쿼리문으로, 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL문이다. (0개째부터 1개의 데이터를 조회, 데이터는 0부터 시작)

```SQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME LIMIT 0,1
```

<br />

#### UNION, UNION ALL

##### UNION

중복된 데이터 없이 두 테이블의 쿼리 결과를 합친다.

아래의 쿼리문은 '오프라인/온라인 판매 데이터 통합하기' 문제의 쿼리문을 일부 변형한 것이다.

```mysql
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE '2022-03-%'
UNION DISTINCT
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE '2022-03-%'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID
```

##### UNION ALL

중복된 데이터를 제거하지 않고 테이블의 모든 데이터를 합친 결과를 반환한다.



아래의 쿼리문은 '오프라인/온라인 판매 데이터 통합하기' 문제의 정답 쿼리문이다.

```mysql
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE '2022-03-%'
UNION ALL
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE '2022-03-%'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID
```

##### 테이블별로 정렬한 후 합치기

만약, 위의 쿼리문과 달리 각각의 테이블을 정렬한 뒤에 합치고 싶다면 아래와 같이 서브쿼리 내에서 ORDER BY로 정렬해준 후 UNION을 실행하면 된다.

```mysql
SELECT Q1,*
FROM (DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
	FROM ONLINE_SALE
	WHERE SALES_DATE LIKE '2022-03-%'
	ORDER BY SALES_DATE, PRODUCT_ID, USER_ID) Q1
UNION ALL
SELECT Q2.*
FROM (DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
	FROM OFFLINE_SALE
	WHERE SALES_DATE LIKE '2022-03-%'
	ORDER BY SALES_DATE, PRODUCT_ID, USER_ID) Q2
```

<br />

<br />

---

### SUM, MAX, MIN

#### 최댓값을 가진 or 최솟값을 가지는 데이터 조회

👉 최댓값을 가지는 데이터를 출력하기 위해서는 내림차순 정렬 후 첫번째 데이터만 출력한다.

아래의 코드는 '가격이 제일 비싼 식품의 정보 출력하기' 문제의 정답 코드이다.

```Mysql
-- 코드를 입력하세요
SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
FROM FOOD_PRODUCT
ORDER BY PRICE DESC LIMIT 1
```

👉 최솟값을 가지는 데이터를 출력하기 위해서는 오름차순 정렬 후 첫번째 데이터만 출력한다.

<br />

#### 집계함수

##### COUNT()

행의 개수를 세는 집계 함수 (단, NULL인 데이터는 제외)

```SQL
SELECT COUNT(*) -- 모든 행의 개수
FROM Students
```

##### DISTINCT()

중복된 행을 제외해주는 집계함수

아래 쿼리문의 경우 birthYear, birthMonth, birthday 값이 모두 같은 행들만 중복으로 취급

```SQL
SELECT DISTINCT birthyear, birthmonth, birthday
FROM Students
```

##### SUM()

모든 컬럼의 데이터를 합해주는 집계함수

```sql
SELECT SUM(AGE)
FROM Students
```

##### AVG()

모든 컬럼의 데이터의 평균을 구하는 집계함수

모든 집계함수는 NULL 값을 제외하고 연산하므로 AVG()도 마찬가지로 NULL 값을 가진 행은 제외하고 평균을 구한다.

```sql
SELECT AVG(AGE)
FROM Students
```

NULL값을 가진 데이터를 0으로 치환한 후 평균에 반영되도록 하기 위해 다음과 같이 쿼리문을 작성할 수 있다.

```sql
SELECT AVG(CASE WHEN AGE IS NULL THEN 0 ELSE AGE END)
FROM Students
```

##### MAX() / MIN()

MAX() : 최대값을 구하는 집계함수

MIN() : 최소값을 구하는 집계함수

MAX(), MIN()는 다른 집계함수와 달리 문자열이나 날짜에도 사용이 가능하다.

```sql
SELECT MAX(AGE), MIN(AGE)
FROM Students
```

<br />

<br />

---

### GROUP BY

#### REGEXP()로 데이터 분류하기

정규표현식을 이용한 조회 함수로, LIKE 연산보다 좀 더 유연한 검색을 할 수 있도록 도와주는 함수

아래의 쿼리문은 '자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기' 문제의 답을 일부 변형한 예시들이다

👉 통풍시트 옵션이 포함된 모든 데이터를 조회

```mysql
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS REGEXP ('통풍시트')
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE
```

해당 쿼리문은 다음과 같이 LIKE 연산을 사용하여 작성할 수 있다

```mysql
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE
```

👉 '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 데이터를 조회

```mysql
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS REGEXP ('통풍시트|열선시트|가죽시트')
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE
```

해당 쿼리문은 다음과 같이 LIKE 연산을 사용하여 작성할 수 있다.

```mysql
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%' OR
	OPTIONS LIKE '%열선시트%' OR
	OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE
```

👉 자동차 종류에 한글이 포함된 데이터를 조회

```mysql
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE REGEXP('[가-힣]')
```

👉 자동차 종류에 한글로만 구성된 데이터를 조회

```mysql
SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE REGEXP('^[가-힣]+$')
```

##### 정규식 기호

| 기호 | 설명                                    |
| :--: | --------------------------------------- |
|  .   | 문자 하나를 나타냄                      |
|  *   | 앞에 나온 문자의 0개 이상 반복을 나타냄 |
|  ^   | 문자열의 처음을 의미                    |
|  $   | 문자열의 끝을 의미                      |
| [.]  | 괄호 안에 문자열 위치를 확인            |
| {.}  | 반복을 나타냄                           |
|  \|  | OR를 의미                               |

⚠ 정규식의 검색을 이용할 시 사용자에게 정규식 기능을 제공해서는 안됨

​	👉 각종 오류가 발생할 수 있고 SQL 인젝션에 취약해지기 때문

​	👉 정규식의 검색을 개발자가 미리 정한 테두리 안에서 이루어져야 함



#### 쿼리에서 변수 활용하기 SET

쿼리에서 변수를 사용하기 위해서는 아래와 같이 변수를 선언해주어야 한다

```mysql
SET @변수명 = 초깃값;
```

아래의 쿼리문은 '입양시각 구하기(2)'의 정답 쿼리문이다

```mysql
SET @hour = -1;

SELECT (@hour := @hour + 1) as HOUR,
    (SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @hour) as COUNT
FROM ANIMAL_OUTS
WHERE @hour < 23;
```

시간을 -1로 초기화하고 SELECT문을 이용하여 조회하는데 이때 WHERE 명령문을 이용하여 hour변수가 23일때 미만인 경우까지만 구한다

쿼리문의 실행 순서는 **FROM - ON - JOIN - WHERE - GROUP BY - HAVING - SELECT - DISTINCT - ORDER BY** 순으로 실행되는데, hour가 22일때까지만 구하여야 1이 더해져 23인 경우까지 조회되기 때문이다



#### 수치연산

##### 사칙연산

| 연산자 |                    함수                    |  연산  |      ex      | 우선순위 |
| :----: | :----------------------------------------: | :----: | :----------: | :------: |
|   +    |                                            |  덧셈  |  1 + 2 -> 3  |    2     |
|   -    |                                            |  뺄셈  | 1 - 2 -> -1  |    2     |
|   *    |                                            |  곱셈  |  1 * 2 -> 2  |    1     |
|   /    | a DIV b 👉 연산자와 달리 정수로 결과가 나옴 | 나눗셈 | 1 / 2 -> 0.5 |    1     |
|   %    |                 MOD(a, b)                  | 나머지 |  1 % 2 -> 1  |    1     |

👉 DIV 외에도 나눗셈의 몫을 정수로 나오게 하는 방법은 다음과 같이 소수점을 버리면 된다

```mysql
TRUNCATE(a/b, 0)
FLOOR(a/b)
```

⚠ WHERE문을 활용한 조건식에서 연산자를 활용할 때에는 SELECT 문의 ALIAS 데이터를 가져오면 안된다

​	👉 WHERE문이 SELECT 문보다 더 빠른 순서로 실행되기 때문에 SELECT 문의 ALIAS를 사용한 데이터를 활용할 수 없다

