--1. 직원명과 주민번호를 조회함
-- 단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
-- 예: 홍길동 771120-1******
SELECT
	EMP_NAME 직원명,
	RPAD(SUBSTR(EMP_NO,1,7),14,'*') 주민번호
FROM EMPLOYEE;

--2. 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 ￦57,000,000으로 표시되게 함
--  연봉은 보너스포인트가 적용된 1년치 급여임
SELECT
	EMP_NAME 직원명,
	JOB_CODE 직급코드,
	TO_CHAR((SALARY*12*(1+NVL(BONUS,0))),'L999,999,999') "연봉(원)"
FROM EMPLOYEE;

--3. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의
-- 사번 사원명 부서코드 입사일
SELECT
	EMP_ID 사번,
	EMP_NAME 사원명,
	DEPT_CODE 부서코드,
	HIRE_DATE 입사일
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE)=2004 AND (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9');

--4. 직원명, 입사일, 입사한 달의 근무일수 조회
-- 단, 주말도 포함함
SELECT
	EMP_NAME 직원명,
	HIRE_DATE 입사일,
	LAST_DAY(HIRE_DATE) - HIRE_DATE + 1 "입사한 달의 근무일수"
FROM EMPLOYEE;


--5. 직원명, 부서코드, 생년월일, 나이(만) 조회
-- 단, 생년월일은 주민번호에서 추출해서,
-- 00년 00월 00일로 출력되게 함.
-- 나이는 주민번호에서 추출해서 날짜 데이터로 변환한 다음, 계산함
SELECT
	EMP_NAME 직원명,
	DEPT_CODE 부서코드,
	SUBSTR(EMP_NO,1,2)||'년 '||SUBSTR(EMP_NO,3,2)||'월 '||SUBSTR(EMP_NO,5,2)||'일' "생년월일",
	--FLOOR((SYSDATE - TO_DATE(SUBSTR(EMP_NO,1,6)))/365) "나이(만)"
	EXTRACT(YEAR FROM SYSDATE) - 
      EXTRACT(YEAR FROM(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD'))) + 1 "나이(만)"
FROM EMPLOYEE;


--6. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
-- 아래의 년도에 입사한 인원수를 조회하시오.
-- =>TO_CHAR, DECODE, SUM 사용

-------------------------------------------------------------
--	전체직원수   2001년   2002년   2003년   2004년
---------------------------------------------------------------
SELECT COUNT(*) 전체인원수,
	COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2001', 1)) "2001년",
    COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2002', 1)) "2002년",
    COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2003', 1)) "2003년",
    COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2004', 1)) "2004년"
FROM EMPLOYEE;

--7.  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회함
--  => case 사용
--   부서코드 기준 오름차순 정렬함.
SELECT
	EMP_ID 사번, EMP_NAME 사원명, DEPT_CODE 부서코드,
	CASE
		WHEN DEPT_CODE = 'D5' THEN '총무부'
		WHEN DEPT_CODE = 'D6' THEN '기획부'
		WHEN DEPT_CODE = 'D9' THEN '영업부'
	END "부서"
FROM EMPLOYEE
WHERE DEPT_CODE ='D5' OR DEPT_CODE = 'D6' OR DEPT_CODE = 'D9'
ORDER BY DEPT_CODE;