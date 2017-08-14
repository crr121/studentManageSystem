package com.zt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 删除学生
	 * 根据id删除
	 */
	public boolean delStudent(int id){
		boolean flg = false;
		//获取到连接
		con = jdbc.getConnection();
		//准备sql语句
		String sql  = "delete from student where id = ?";
		//预处理
		try {
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, id);
			 //执行SQL语句
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
	
	/**
	 * 查询所有学生
	 * 返回一个结果集
	 */
	public List<Student> findAll(){
		//注意这里new的是array list，而不是list，list是一个接口，不能new
		//arraylist 是一个对象
		List<Student> stus = new ArrayList<Student>();
		//获取连接
		con = jdbc.getConnection();
		Student stu = null;
		//准备SQL语句
		String sql = "select id,name,age,sex,grade,tel,email,addr from student";
		//预处理
		try {
		     ps = con.prepareStatement(sql);
		     //执行SQL语句
		      rs = ps.executeQuery();
		      //从结果集取出添加在stus返回
		      //这里的结果集就相当于一个游标
		      //需要不断的取出一个一个的对象的字段，然后封装成一个student对象，然后再组装成一个结果集返回
		      //相当于这里的rs是一个指针从数据库中的student表依次从第一行开始取出
		      //所以这里我们需要一个while循环，来让指针走动
		      while(rs.next()){
		    	  int id = rs.getInt("id");
			      String name = rs.getString("name");
			      int age = rs.getInt("age");
			      String sex = rs.getString("sex");
			      String grade = rs.getString("grade");
			      String tel = rs.getString("tel");
			      String email = rs.getString("email");
			      String addr = rs.getString("addr");
			      //将取出的字段组装成一个student对象
			      stu = new Student(id, name, age, sex, grade, tel, email, addr);
			      //将对象添加到list集合stus中
			      stus.add(stu);
		      }
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbc.closeAll(con, ps, rs);
		}
		return stus;
	}
	
	
	
	
	
	
}
