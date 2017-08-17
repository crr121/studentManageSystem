package com.zt.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.zt.entity.Admin;
import com.zt.entity.Student;
import com.zt.service.AdminService;
import com.zt.service.StudentService;

public class UserInterface {
	private AdminService as = new AdminService();
	private StudentService ss = new StudentService();
	Scanner sc = new Scanner(System.in);
	int no = -1;
	Student student = null;
	boolean flg ;
	int id;
	//写一个main函数，作为程序的入口
	//这里我们因为导入了junit4包，所以直接调用这个包就行了
	@Test
	public void initCode(){
		UserInterface ui = new UserInterface();
		no = ui.initLogin();
		ui.login(no);
		no = initFun();
		funChoose(no);
	}
	//第一部分是登陆，写一个登陆的函数
	public int initLogin(){
		System.out.println("---------------------欢迎登陆学生信息管理系统-----------------------");
		System.out.println("1. 登陆            2. 退出");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("请选择：");
		no = sc.nextInt();
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
//			 System.out.println(loginResult);
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
	//功能的选择
	
	public int initFun(){
		System.out.println("***********************请选择要操作的信息对应的数字*****************************");
		System.out.println("*1.查看学生信息   2.添加学生信息  3.修改学生信息   4.删除学生信息  5.退出*");
		System.out.println("******************************************************************************");
	    System.out.println("请选择：");
	    no = sc.nextInt();
	    return no;
	}
	public void funChoose(int no){
	    if(no==1){
	    	find();
	    }else if(no==2){
	    	add();
	    }else if(no==3){
	    	update();
	    }else if(no==4){
	    	
	    }else{
	    	
	    }
	    
	}
	/**
	 * 功能选择1：查看学生信息
	 */
	public void find(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+1.查看所有学生信息     2.根据id查询学生信息     3.返回上一层+");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("请选择菜单：");
		no = sc.nextInt();
		if(no==1){
			ss.findAll();
		}else if(no==2){
			System.out.println("请输入学生id：");
			int id = sc.nextInt();
			ss.findById(id);
		}else{
			initFun();
		}
	}
	/**
	 * 功能选择2：添加学生
	 */
	public void add(){
		System.out.println("请输入学生id");
		id = sc.nextInt();
		//在添加之前先查找数据库中是否存在该id
		student = ss.findById(id);
		if(student!=null){
			//如果返回的值不为空，说明该id已经存在，重新加载添加函数add()
			System.out.println("此id"+student.getId()+"已经存在！");
			add();
		}
		//如果返回的值为空，就继续添加学生的姓名，年龄等字段
		System.out.println("请输入学生姓名：");
		String name = sc.next();
		System.out.println("请输入学生年龄：");
		int age = sc.nextInt();
		System.out.println("请输入学生性别：");
		String sex = sc.next();
		System.out.println("请输入学生年纪：");
		String grade = sc.next();
		System.out.println("请输入学生电话：");
		String tel = sc.next();
		System.out.println("请输入学生邮箱：");
		String email = sc.next();
		System.out.println("请输入学生地址：");
		String addr = sc.next();
		//添加好字段之后，组装成一个student对象，然后调用DAO中的saveStudent()方法
		student = new Student(id, name, age, sex, grade, tel, email, addr);
		flg = ss.save(student);
		if(flg){
			System.out.println("学生"+student.getId()+"添加成功，系统将返回上级....");
		}
	}

	/**
	 * 功能选择3：修改学生信息
	 */
	public void update(){
		System.out.println("请输入需要修改的学生id:");
		id = sc.nextInt();
		//向数据库查询是否存在该学生
		student= ss.findById(id);
		if(student==null){
			System.out.println("不存在该学生！请重新输入！！！");
			update();
		}
		System.out.println("您要修改的学生信息为："+student);
		flg = ss.update(student);
		if(flg){
			System.out.println("修改成功！！！");
		}
		
	}
	/*
	 * 功能选择4：删除学生
	 */

	public void delete(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+1.根据id删除            2.返回到上级+");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("请选择删除方式：");
		no = sc.nextInt();
		if(no==1){
			System.out.println("请输入要删除的学生id：");
			id = sc.nextInt();
			ss.delStu(id);
			System.out.println("删除完毕，将自动返回上级目录");
			find();
		}else if(no==2){
			System.out.println("将自动返回上级...");
			initFun();
		}else{
			System.out.println("输入有误！！！");
			initFun();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
