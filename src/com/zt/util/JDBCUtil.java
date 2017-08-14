package com.zt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
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
	public Connection con (){
		Connection con = null;
		try {
			con = DriverManager.getConnection(rb.getString("url"));
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
