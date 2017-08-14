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
	 * ���ѧ��
	 * ��ӵ�ѧ����Ϣͨ����װ��һ��student������Ϊ�����Ĳ�����ӽ���
	 * ���ݸ�ps,Ȼ����ps��ӽ����ݿ�
	 */
	public boolean save(Student stu){
		boolean flg =false;
	    con = jdbc.getConnection();
	    try {
	    	String sql = "insert into student(id,name,age,sex,grade,tel,emai,addr) values(seq_student.nextval,?,?,?,?,?,?,?)";
	    	//�����ÿһ���ʺŶ���Ҫͨ��psԤ��������ֵ
	    	//����ֵ��Ҫ���ͨ��һ��student����Ĳ���������
	    	//Ȼ����ps��ӽ����ݿ�
	    	//ps��ֱ�Ӻ����ݿ��е����ݱ�򽻵�
	    	//������ps���ʺŸ�ֵ��ʱ��һ��Ҫһһ��Ӧ�������Ǵ��ʺŵĸ�����ʼ��
	    	//�����������ʾ�ڼ����ʺţ������ǵڼ����ֶ�
	    	/**
	    	 * �ڽ��и�ֵ֮ǰ����Ҫ����Ԥ����
	    	 */
	    	ps = con.prepareStatement(sql);
	    	//׼������SQL��仹��Ҫд������д��һ������һ��Ԥ����Ĺ���
	    	//��Ȼ���渳ֵ��ps������
	    	//����ĵ�һ������ֱ�������ݿ��Զ����ɵ����н��и�ֵ
	    	//��������ӵڶ����ֶο�ʼ��ֵ
			 ps.setString(1, stu.getName());
			 ps.setInt(2, stu.getAge());
			 ps.setString(3, stu.getSex());
			 ps.setString(4, stu.getGrade());
			 ps.setString(5, stu.getTel());
			 ps.setString(6, stu.getEmail());
			 ps.setString(7, stu.getAddr());
			 //��ÿ���ʺŸ�ֵ��֮����ǿ�ʼִ��SQL�����
			 //����ִ��SQL���Ӧ����executeupdate����
			 //���ص���Ӱ������������ִ�гɹ�������count��0
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
	 * ɾ��ѧ��
	 * ����idɾ��
	 */
	public boolean delStudent(int id){
		boolean flg = false;
		//��ȡ������
		con = jdbc.getConnection();
		//׼��sql���
		String sql  = "delete from student where id = ?";
		//Ԥ����
		try {
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, id);
			 //ִ��SQL���
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
	 * ��ѯ����ѧ��
	 * ����һ�������
	 */
	public List<Student> findAll(){
		//ע������new����array list��������list��list��һ���ӿڣ�����new
		//arraylist ��һ������
		List<Student> stus = new ArrayList<Student>();
		//��ȡ����
		con = jdbc.getConnection();
		Student stu = null;
		//׼��SQL���
		String sql = "select id,name,age,sex,grade,tel,email,addr from student";
		//Ԥ����
		try {
		     ps = con.prepareStatement(sql);
		     //ִ��SQL���
		      rs = ps.executeQuery();
		      //�ӽ����ȡ�������stus����
		      //����Ľ�������൱��һ���α�
		      //��Ҫ���ϵ�ȡ��һ��һ���Ķ�����ֶΣ�Ȼ���װ��һ��student����Ȼ������װ��һ�����������
		      //�൱�������rs��һ��ָ������ݿ��е�student�����δӵ�һ�п�ʼȡ��
		      //��������������Ҫһ��whileѭ��������ָ���߶�
		      while(rs.next()){
		    	  int id = rs.getInt("id");
			      String name = rs.getString("name");
			      int age = rs.getInt("age");
			      String sex = rs.getString("sex");
			      String grade = rs.getString("grade");
			      String tel = rs.getString("tel");
			      String email = rs.getString("email");
			      String addr = rs.getString("addr");
			      //��ȡ�����ֶ���װ��һ��student����
			      stu = new Student(id, name, age, sex, grade, tel, email, addr);
			      //��������ӵ�list����stus��
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
