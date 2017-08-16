package com.zt.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.zt.entity.Admin;
import com.zt.service.AdminService;

public class UserInterface {
	private AdminService as = new AdminService();
	Scanner sc = new Scanner(System.in);
	//写一个main函数，作为程序的入口
	//这里我们因为导入了junit4包，所以直接调用这个包就行了
	@Test
	public void initCode(){
		UserInterface ui = new UserInterface();
		int no = ui.initLogin();
		ui.login(no);
	}
	//第一部分是登陆，写一个登陆的函数
	public int initLogin(){
		System.out.println("---------------------欢迎登陆学生信息管理系统-----------------------");
		System.out.println("1. 登陆            2. 退出");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("请选择：");
		int no = sc.nextInt();
		return no;
		
	}
	public boolean login(int no){
		if(no==1){
			System.out.println("欢迎登陆");
			System.out.println("请输入用户名：");
			String username = sc.next();
			System.out.println("请输入密码：");
			String pwd = sc.next();
			//这里我们从用户界面拿到了用户名和密码
			//那么接下来就需要从数据库中去查询是否存在对应的用户名和密码
			//那么如何将用户的数据传递到数据库中去呢
			//这里我们需要一个service做中间的传递作用
			 Admin loginResult = as.loginService(username, pwd);
			 System.out.println(loginResult);
			if(loginResult!=null){
				System.out.println("登陆成功");
				System.out.println("欢迎您  "+loginResult.getUsername());
				return true;
			}else{
				login(1);
			}
		}else if(no==2){
			System.out.println("即将退出系统！");
		}else{
			System.out.println("您的输入有误！请重新输入");
			initCode();
		}
		return false;
	}
	
}
