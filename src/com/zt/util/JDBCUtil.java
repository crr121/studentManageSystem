package com.zt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
   //加载驱动
	//这里的rb是给静态块调用的，所以一定要为static属性
	//静态只能调用静态的
	private static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
	static{
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   //获取连接
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
   //删除连接
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
