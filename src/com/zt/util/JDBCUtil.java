package com.zt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	//用main函数来测试
	public static void main(String[] args) {
		JDBCUtil jdbc = new JDBCUtil();
	
		Connection con = jdbc.getConnection();
		System.out.println(con);
	}
	//打印结果：oracle.jdbc.driver.T4CConnection@3a0d2766

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
	public Connection getConnection (){
		//注意这里的连接函数的名字要和DAO里面对应起来
		//这里用的什么名字，在DAO文件里面用jdbc.getConnection来调用
		Connection con = null;
		try {
			//这里获取连接是DriverManager.getConnection(url, user, password)
			//需要选择三个参数的
			con = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));
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
