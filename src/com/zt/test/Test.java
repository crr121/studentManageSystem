package com.zt.test;

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
}
