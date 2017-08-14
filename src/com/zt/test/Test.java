package com.zt.test;

import com.zt.dao.StudentDAO;
import com.zt.entity.Student;

public class Test {
	StudentDAO sd = new StudentDAO();
	//Student stu = null;
 
	/**
	 * 测试添加学生
	 */
	@org.junit.Test
	public void testSave(){
		Student stu = new Student(-1, "张三", 12, "男","中级" , "12345678901", "12334455@qq.com", "北京");
		
		boolean flg = sd.save(stu);
		System.out.println(flg);
	}
}
