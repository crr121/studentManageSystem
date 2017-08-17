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
	//дһ��main��������Ϊ��������
	//����������Ϊ������junit4��������ֱ�ӵ��������������
	@Test
	public void initCode(){
		UserInterface ui = new UserInterface();
		no = ui.initLogin();
		ui.login(no);
		no = initFun();
		funChoose(no);
	}
	//��һ�����ǵ�½��дһ����½�ĺ���
	public int initLogin(){
		System.out.println("---------------------��ӭ��½ѧ����Ϣ����ϵͳ-----------------------");
		System.out.println("1. ��½            2. �˳�");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("��ѡ��");
		no = sc.nextInt();
		return no;
		
	}
	public boolean login(int no){
		if(no==1){
			System.out.println("��ӭ��½");
			System.out.println("�������û�����");
			String username = sc.next();
			System.out.println("���������룺");
			String pwd = sc.next();
			//�������Ǵ��û������õ����û���������
			//��ô����������Ҫ�����ݿ���ȥ��ѯ�Ƿ���ڶ�Ӧ���û���������
			//��ô��ν��û������ݴ��ݵ����ݿ���ȥ��
			//����������Ҫһ��service���м�Ĵ�������
			 Admin loginResult = as.loginService(username, pwd);
//			 System.out.println(loginResult);
			if(loginResult!=null){
				System.out.println("��½�ɹ�");
				System.out.println("��ӭ��  "+loginResult.getUsername());
				return true;
			}else{
				login(1);
			}
		}else if(no==2){
			System.out.println("�����˳�ϵͳ��");
		}else{
			System.out.println("����������������������");
			initCode();
		}
		return false;
	}
	//���ܵ�ѡ��
	
	public int initFun(){
		System.out.println("***********************��ѡ��Ҫ��������Ϣ��Ӧ������*****************************");
		System.out.println("*1.�鿴ѧ����Ϣ   2.���ѧ����Ϣ  3.�޸�ѧ����Ϣ   4.ɾ��ѧ����Ϣ  5.�˳�*");
		System.out.println("******************************************************************************");
	    System.out.println("��ѡ��");
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
	 * ����ѡ��1���鿴ѧ����Ϣ
	 */
	public void find(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+1.�鿴����ѧ����Ϣ     2.����id��ѯѧ����Ϣ     3.������һ��+");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("��ѡ��˵���");
		no = sc.nextInt();
		if(no==1){
			ss.findAll();
		}else if(no==2){
			System.out.println("������ѧ��id��");
			int id = sc.nextInt();
			ss.findById(id);
		}else{
			initFun();
		}
	}
	/**
	 * ����ѡ��2�����ѧ��
	 */
	public void add(){
		System.out.println("������ѧ��id");
		id = sc.nextInt();
		//�����֮ǰ�Ȳ������ݿ����Ƿ���ڸ�id
		student = ss.findById(id);
		if(student!=null){
			//������ص�ֵ��Ϊ�գ�˵����id�Ѿ����ڣ����¼�����Ӻ���add()
			System.out.println("��id"+student.getId()+"�Ѿ����ڣ�");
			add();
		}
		//������ص�ֵΪ�գ��ͼ������ѧ����������������ֶ�
		System.out.println("������ѧ��������");
		String name = sc.next();
		System.out.println("������ѧ�����䣺");
		int age = sc.nextInt();
		System.out.println("������ѧ���Ա�");
		String sex = sc.next();
		System.out.println("������ѧ����ͣ�");
		String grade = sc.next();
		System.out.println("������ѧ���绰��");
		String tel = sc.next();
		System.out.println("������ѧ�����䣺");
		String email = sc.next();
		System.out.println("������ѧ����ַ��");
		String addr = sc.next();
		//��Ӻ��ֶ�֮����װ��һ��student����Ȼ�����DAO�е�saveStudent()����
		student = new Student(id, name, age, sex, grade, tel, email, addr);
		flg = ss.save(student);
		if(flg){
			System.out.println("ѧ��"+student.getId()+"��ӳɹ���ϵͳ�������ϼ�....");
		}
	}

	/**
	 * ����ѡ��3���޸�ѧ����Ϣ
	 */
	public void update(){
		System.out.println("��������Ҫ�޸ĵ�ѧ��id:");
		id = sc.nextInt();
		//�����ݿ��ѯ�Ƿ���ڸ�ѧ��
		student= ss.findById(id);
		if(student==null){
			System.out.println("�����ڸ�ѧ�������������룡����");
			update();
		}
		System.out.println("��Ҫ�޸ĵ�ѧ����ϢΪ��"+student);
		flg = ss.update(student);
		if(flg){
			System.out.println("�޸ĳɹ�������");
		}
		
	}
	/*
	 * ����ѡ��4��ɾ��ѧ��
	 */

	public void delete(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+1.����idɾ��            2.���ص��ϼ�+");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("��ѡ��ɾ����ʽ��");
		no = sc.nextInt();
		if(no==1){
			System.out.println("������Ҫɾ����ѧ��id��");
			id = sc.nextInt();
			ss.delStu(id);
			System.out.println("ɾ����ϣ����Զ������ϼ�Ŀ¼");
			find();
		}else if(no==2){
			System.out.println("���Զ������ϼ�...");
			initFun();
		}else{
			System.out.println("�������󣡣���");
			initFun();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
