package com.zt.test;

import java.util.List;

import com.zt.dao.StudentDAO;
import com.zt.entity.Student;

public class Test {
	StudentDAO sd = new StudentDAO();
	//Student stu = null;
 
	/**
	 * �������ѧ��
	 */
	@org.junit.Test
	public void testSave(){
		Student stu = new Student(-1, "����", 12, "��","�м�" , "12345678901", "12334455@qq.com", "����");
		
		boolean flg = sd.save(stu);
		System.out.println(flg);
	}
	
	/**
	 * ����ɾ��ѧ��
	 * ɾ��֮ǰ��Ҫ�鿴��ѧ���Ƿ����
	 * ��Ҫ����һ��id
	 */
	@org.junit.Test
	public void testDel(){
		boolean flg = false;
		flg = sd.delStudent(23);
		System.out.println(flg);
		
	}
	
	/**
	 * ���Բ�ѯ���е�ѧ��
	 * ����һ�������
	 */
	@org.junit.Test
	public void testFindAll(){
		List<Student> stus = sd.findAll();
		for (Student student : stus) {
			System.out.println(student);
		}
	}
	/**
	 * �����޸�ѧ��
	 * ��Ҫ������Ҫ�޸ĵ�ѧ�����ֶ�
	 * ���ز���ֵ
	 */
	public void testUpdate(){
		//���޸�֮ǰ�ȸ���id��ѯ
		
	}
	
}
