package com.zt.service;

import java.util.List;

import com.zt.dao.AdminDAO;
import com.zt.entity.Admin;
//loginservice就是将用户输入的数据组装成一个admin的对象
//然后作为参数传递给数据库操纵函数DAO进行查询
//这里只需要传入用户名和密码
//所以在组装对象admin的时候，mid可以直接设置为-1
public class AdminService {
	AdminDAO ad = new AdminDAO();
    public Admin loginService(String username, String pwd){
    	Admin admin = new Admin(-1,username, pwd);
    	return  ad.findByPN(admin);
    }
}
