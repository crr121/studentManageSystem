package com.zt.entity;

public class Admin {
  private int id;
  private String username;
  private String pwd;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(int id, String username, String pwd) {
	super();
	this.id = id;
	this.username = username;
	this.pwd = pwd;
}
@Override
public String toString() {
	return "Admin [id=" + id + ", username=" + username + ", pwd=" + pwd + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	Admin other = (Admin) obj;
	if (id != other.id)
		return false;
	if (pwd == null) {
		if (other.pwd != null)
			return false;
	} else if (!pwd.equals(other.pwd))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
  
  
}
