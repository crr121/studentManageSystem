package com.zt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zt.entity.Admin;
import com.zt.util.JDBCUtil;


public class AdminDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
   /**
    * 查询，根据用户名和密码查询
    */
	public Admin findByPN(){
		Admin admin = new Admin();
		con = jdbc.getConnection();
		String sql = "select username,pwd from admin where username = ? and pwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
