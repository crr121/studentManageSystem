package com.zt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zt.entity.Student;
import com.zt.util.JDBCUtil;


public class StudentDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
	/*
	 * 添加学生
	 * 添加的学生信息通过包装成一个student对象作为函数的参数添加进来
	 * 传递给ps,然后由ps添加进数据库
	 */
	public boolean save(Student stu){
		boolean flg =false;
	    con = jdbc.getConnection();
	    try {
	    	String sql = "insert into student(id,name,age,sex,grade,tel,emai,addr) values(seq_student.nextval,?,?,?,?,?,?,?)";
	    	//这里的每一个问号都需要通过ps预处理来赋值
	    	//赋的值需要外界通过一个student对象的参数传进来
	    	//然后由ps添加进数据库
	    	//ps是直接和数据库中的数据表打交道
	    	//这里由ps给问号赋值的时候一定要一一对应，并且是从问号的个数开始的
	    	//这里的索引表示第几个问号，而不是第几个字段
	    	/**
	    	 * 在进行赋值之前还需要进行预处理
	    	 */
	    	ps = con.prepareStatement(sql);
	    	//准备好了SQL语句还需要写出来，写这一步就是一个预处理的过程
	    	//不然后面赋值的ps从哪来
	    	//这里的第一个参数直接由数据库自动生成的序列进行赋值
	    	//所以这里从第二个字段开始赋值
			 ps.setString(1, stu.getName());
			 ps.setInt(2, stu.getAge());
			 ps.setString(3, stu.getSex());
			 ps.setString(4, stu.getGrade());
			 ps.setString(5, stu.getTel());
			 ps.setString(6, stu.getEmail());
			 ps.setString(7, stu.getAddr());
			 //给每个问号赋值好之后就是开始执行SQL语句了
			 //这里执行SQL语句应该用executeupdate方法
			 //返回的是影响的行数，如果执行成功，就是count》0
			 int count = ps.executeUpdate();
			 if(count>0){
				 flg=true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flg;
	}

}
