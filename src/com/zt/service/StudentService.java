package com.zt.service;

import java.util.List;

import com.zt.dao.StudentDAO;
import com.zt.entity.Student;

public class StudentService {
	private StudentDAO sd = new StudentDAO();
	private Student stu = null;
	private boolean flg ;
	/**
	 * 查询学生
	 * @return
	 */
	public List<Student> findAll(){
	List<Student> findAll = sd.findAll();
	return findAll;
	}
	/**
	 * 根据id查询学生
	 */
	public Student findById(int id){
		stu= null;
		stu = sd.findById(id);
		return stu;
	}
	/**
	 * 添加学生
	 */
	public boolean save(Student student){
		return sd.save(student);
		
	}
	/**
	 * 修改学生
	 */
	public boolean update(Student student){
		boolean flg = sd.updateStudent(student);
	return flg;
	}
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	public void delStu(int id){
		//在删除之前需要先查询需要删除的id是否在数据库中存在
		//这种逻辑处理一般都在service里面处理
		//然后页面端直接调用service里面的删除函数即可
		stu = sd.findById(id);
		if(stu==null){
			System.out.println("该学生不存在！！");
			//由于这里删除函数定义的是void函数空类型
			//所以这里的return只是一个结束函数的作用
			return;
		}
		flg = sd.delStudent(id);
		if(flg){
			System.out.println("删除成功！！！");
		}else{
			System.out.println("删除失败");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
