package com.zt.entity;

public class Admin {
  private String username;
  private String pwd;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(String username, String pwd) {
	super();
	this.username = username;
	this.pwd = pwd;
}
@Override
public String toString() {
	return "Admin [username=" + username + ", pwd=" + pwd + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
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
