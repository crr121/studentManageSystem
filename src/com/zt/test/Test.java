package com.zt.test;

import java.util.List;

import com.zt.dao.AdminDAO;
import com.zt.dao.StudentDAO;
import com.zt.entity.Admin;
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
		Student stu = sd.findById(26);
		flg = sd.delStudent(stu.getId());
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
	 * ����id��ѯ����
	 */
	//һ��Ҫ�ǵò��Ե�ʱ��������test������
	//����junit.jar��
	@org.junit.Test
	public void testFindById(){
		Student stu = sd.findById(24);
		System.out.println(stu);
	}
	/**
	 * �����޸�ѧ��
	 * �޸�֮ǰ��Ҫ��ͨ��findById�õ���Ӧ��student����
	 * ��Ҫ������Ҫ�޸ĵ�ѧ�����ֶ�
	 * ���ز���ֵ
	 */
	@org.junit.Test
	public void testUpdate(){
		//���޸�֮ǰ�ȸ���id��ѯ
		Student stu = sd.findById(27);
		System.out.println(stu);
		stu.setName("��liu");
		boolean flg = sd.updateStudent(stu);
		System.out.println(flg);
		System.out.println(stu);
	}
	/**
	 * �����û����������ѯ����Ա�˺�
	 */
	@org.junit.Test
	public void testAdmin(){
		AdminDAO ad = new AdminDAO();
		Admin admin = new Admin(1, "admin", "234");
	    Admin findByPN = ad.findByPN(admin);
	    System.out.println(findByPN);
	}
	
}
