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
    * ��ѯ�������û����������ѯ
    * //���ﴫ�������ʱ��ֱ�Ӵ���һ��admin �Ķ���
		//�����������id��ѯ��ʱ��ֱ�Ӵ���һ��id����
		//�����൱����Ҫ�ж��û�����������붼Ҫһ�²��ܽ����ݿ��еĶ��󷵻�
		
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
