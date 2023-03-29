--==========================================
-- 관리자 계정
--===========================================
create user mybatis
identified by mybatis
default tablespace users;
grant connect, resource to mybatis;

--=====================================
--mybatis 계정
--=====================================

create table student(
    no number,
    name varchar2(100) not null,
    tel char(11) not null,
    reg_date date default sysdate,
    constraint pk_student_no primary key(no)

);

create sequence seq_student_no;

select * from student;


-----------oracle synonym객체
--동의어 객체. 별칭 객체

--mybatis 계정에서 kh계정의 table접근 --접근 권한이 없어서 접근이 불가할 뿐 존재는 한다.
--관리자가 권한을 부여하던지 하면 된다

select * from kh.employee; --emp
select * from kh.department;--dept
select * from kh.job; --job

--동의어 생성
--이대로 생성은 권한이 없기 때문에 불가하다 (resource롤에  create synonym은 포함되어 있지 않다)
create synonym emp for  kh.employee;
create synonym dept for  kh.department;
create synonym job for  kh.job;

select * 
from emp e;
select * from dept;
select * from job;
--================================
--system계정
--================================
grant all on kh.employee to mybatis;
grant select on kh.department to mybatis; 
grant select on kh.job to mybatis; 

--이 권한을 부여해야지 위에 동의어 생성 가능
grant create synonym to mybatis;

--==================================

	select *
		from emp E
	   join job j
	   on e.job_code = j.job_code;

	select
	 		dept_id "deptCode",
	 		dept_title "deptTitle"
		from 
			dept;
            
-----직급 코드가    J1,J2,J3
select *
from emp
where job_code in ( 'J1','J2','J3');
