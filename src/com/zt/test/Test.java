package com.zt.test;

import java.util.List;

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
	
	/**
	 * 测试删除学生
	 * 删除之前需要查看该学生是否存在
	 * 需要传入一个id
	 */
	@org.junit.Test
	public void testDel(){
		boolean flg = false;
		flg = sd.delStudent(23);
		System.out.println(flg);
		
	}
	
	/**
	 * 测试查询所有的学生
	 * 返回一个结果集
	 */
	@org.junit.Test
	public void testFindAll(){
		List<Student> stus = sd.findAll();
		for (Student student : stus) {
			System.out.println(student);
		}
	}
	/**
	 * 测试修改学生
	 * 需要传入需要修改的学生的字段
	 * 返回布尔值
	 */
	public void testUpdate(){
		//在修改之前先根据id查询
		
	}
	
}
