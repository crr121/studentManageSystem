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
		Student stu = sd.findById(26);
		flg = sd.delStudent(stu.getId());
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
	 * 根据id查询数据
	 */
	//一定要记得测试的时候先引入test主方法
	//导入junit.jar包
	@org.junit.Test
	public void testFindById(){
		Student stu = sd.findById(24);
		System.out.println(stu);
	}
	/**
	 * 测试修改学生
	 * 修改之前需要先通过findById拿到对应的student对象
	 * 需要传入需要修改的学生的字段
	 * 返回布尔值
	 */
	@org.junit.Test
	public void testUpdate(){
		//在修改之前先根据id查询
		Student stu = sd.findById(27);
		System.out.println(stu);
		stu.setName("王liu");
		boolean flg = sd.updateStudent(stu);
		System.out.println(flg);
		System.out.println(stu);
	}
	/**
	 * 根据用户名和密码查询管理员账号
	 */
	@org.junit.Test
	public void testAdmin(){
		AdminDAO ad = new AdminDAO();
		Admin admin = new Admin(1, "admin", "234");
	    Admin findByPN = ad.findByPN(admin);
	    System.out.println(findByPN);
	}
	
}
