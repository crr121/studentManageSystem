package com.zt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zt.entity.Admin;
import com.zt.util.JDBCUtil;


public class AdminDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	JDBCUtil jdbc = new JDBCUtil();
   /**
    * 查询，根据用户名和密码查询
    * //这里传入参数的时候直接传入一个admin 的对象
		//而不是像根据id查询的时候直接传入一个id进来
		//这里相当于是要判断用户名和密码必须都要一致才能将数据库中的对象返回
		
    */
	public Admin findByPN(Admin admin){
		con = jdbc.getConnection();
		String sql = "select mid, username,pwd from admin where username = ? and pwd =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPwd());
			rs = ps.executeQuery();
			if(rs.next()){
				int mid = rs.getInt(1);
				String username = rs.getString(2);
				String pwd = rs.getString(3);
				admin = new Admin(mid,username, pwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeAll(con, ps, rs);
		}
		return admin;
	}
}
