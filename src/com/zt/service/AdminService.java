package com.zt.service;

import java.util.List;

import com.zt.dao.AdminDAO;
import com.zt.entity.Admin;
//loginservice���ǽ��û������������װ��һ��admin�Ķ���
//Ȼ����Ϊ�������ݸ����ݿ���ݺ���DAO���в�ѯ
//����ֻ��Ҫ�����û���������
//��������װ����admin��ʱ��mid����ֱ������Ϊ-1
public class AdminService {
	AdminDAO ad = new AdminDAO();
    public Admin loginService(String username, String pwd){
    	Admin admin = new Admin(-1,username, pwd);
    	return  ad.findByPN(admin);
    }
}
