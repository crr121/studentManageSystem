--管理员
create table admin(
mid int  primary key,
username varchar2(25),
pwd varchar2(20)--一定注意最后一行没有逗号
);
--给管理员表创建序列，把序列当作管理员的id
create sequence seq_admin;
--由于这里我们不做注册验证的功能
--所以直接从数据库中添加管理员的账户
--这里赋值的时候直接将序列的下一个赋值给mid
insert into admin values(seq_admin.nextval,'admin','admin');
select * from admin;
--学生表
create table student(
id int primary  key,
name varchar2(25),
age int,
sex varchar2(2),
grade varchar2(4),
tel varchar2(11),
email varchar2(50),
addr varchar2(100)
);
--创建学生表的索引
create sequence seq_student;
select * from student;
select * from dept;
select deptno,dname,loc from dept where dname='SALES' and loc='CHICAGO';
