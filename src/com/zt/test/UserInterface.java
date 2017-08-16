package com.zt.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.zt.entity.Admin;
import com.zt.service.AdminService;

public class UserInterface {
	private AdminService as = new AdminService();
	Scanner sc = new Scanner(System.in);
	//дһ��main��������Ϊ��������
	//����������Ϊ������junit4��������ֱ�ӵ��������������
	@Test
	public void initCode(){
		UserInterface ui = new UserInterface();
		int no = ui.initLogin();
		ui.login(no);
	}
	//��һ�����ǵ�½��дһ����½�ĺ���
	public int initLogin(){
		System.out.println("---------------------��ӭ��½ѧ����Ϣ����ϵͳ-----------------------");
		System.out.println("1. ��½            2. �˳�");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("��ѡ��");
		int no = sc.nextInt();
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
			 System.out.println(loginResult);
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
	
}
