--����Ա
create table admin(
mid int  primary key,
username varchar2(25),
pwd varchar2(20)--һ��ע�����һ��û�ж���
);
--������Ա���������У������е�������Ա��id
create sequence seq_admin;
--�����������ǲ���ע����֤�Ĺ���
--����ֱ�Ӵ����ݿ������ӹ���Ա���˻�
--���︳ֵ��ʱ��ֱ�ӽ����е���һ����ֵ��mid
insert into admin values(seq_admin.nextval,'admin','admin');
select * from admin;
--ѧ����
create table student(
id int primary  key,
name varchar2(25),
age int,
sex varchar2(2),
grade varchar2(4),
tel varchar2(11),
emai varchar2(50),
addr varchar2(100)
);
--����ѧ����������
create sequence seq_student;