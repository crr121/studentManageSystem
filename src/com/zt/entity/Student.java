package com.zt.entity;
//package entity;

public class Student {
   private int id;
   private String name;
   private int age;
   private String sex;
   private String grade;
   private String tel;
   private String email;
   private String addr;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String name, int age, String sex, String grade,
		String tel, String email, String addr) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.sex = sex;
	this.grade = grade;
	this.tel = tel;
	this.email = email;
	this.addr = addr;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex="
			+ sex + ", grade=" + grade + ", tel=" + tel + ", email=" + email
			+ ", addr=" + addr + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((addr == null) ? 0 : addr.hashCode());
	result = prime * result + age;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((grade == null) ? 0 : grade.hashCode());
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((sex == null) ? 0 : sex.hashCode());
	result = prime * result + ((tel == null) ? 0 : tel.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	if (addr == null) {
		if (other.addr != null)
			return false;
	} else if (!addr.equals(other.addr))
		return false;
	if (age != other.age)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (grade == null) {
		if (other.grade != null)
			return false;
	} else if (!grade.equals(other.grade))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (sex == null) {
		if (other.sex != null)
			return false;
	} else if (!sex.equals(other.sex))
		return false;
	if (tel == null) {
		if (other.tel != null)
			return false;
	} else if (!tel.equals(other.tel))
		return false;
	return true;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
   
   
}
