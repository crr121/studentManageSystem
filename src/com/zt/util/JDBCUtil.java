package com.zt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	//��main����������
	public static void main(String[] args) {
		JDBCUtil jdbc = new JDBCUtil();
	
		Connection con = jdbc.getConnection();
		System.out.println(con);
	}
	//��ӡ�����oracle.jdbc.driver.T4CConnection@3a0d2766

   //��������
	//�����rb�Ǹ���̬����õģ�����һ��ҪΪstatic����
	//��ֻ̬�ܵ��þ�̬��
	private static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
	static{
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   //��ȡ����
	public Connection getConnection (){
		//ע����������Ӻ���������Ҫ��DAO�����Ӧ����
		//�����õ�ʲô���֣���DAO�ļ�������jdbc.getConnection������
		Connection con = null;
		try {
			//�����ȡ������DriverManager.getConnection(url, user, password)
			//��Ҫѡ������������
			con = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
				
	}
   //ɾ������
   public void closeAll(Connection con,Statement st,ResultSet rs){
	
		 try {
			 if(rs!=null){
			rs.close();
			 }
			 if(st!=null){
				 st.close();
			 }
			 if(con!=null){
				 con.close();
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	   
   }
}
