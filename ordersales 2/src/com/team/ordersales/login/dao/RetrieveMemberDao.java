package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.login.entity.LoginUserEntity;

public class RetrieveMemberDao {
	
	private static Connection conn = null;
	
	public static List<LoginUserEntity> 
			getMemberList(String id) {
		List<LoginUserEntity> llist = new ArrayList<LoginUserEntity>();
//		List<String> slist = new ArrayList<String>();
		LoginUserEntity le = null;
		
		String sqlUser = "SELECT id, passwd, phonenum, role, addr  FROM userinfo WHERE id = ?";
		
		conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		try {
			
			pstmt = conn.prepareStatement(sqlUser);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				le = new LoginUserEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				llist.add(le);
			}
			
			System.out.println("11");
			
			rs.close();
			pstmt.close();
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return llist;
	}
			
}





