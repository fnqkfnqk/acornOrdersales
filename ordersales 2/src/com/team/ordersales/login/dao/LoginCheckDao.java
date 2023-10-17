package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.ordersales.comm.ConfigureImpl;

public class LoginCheckDao {
	
	private static Connection conn = null;
	
	public static boolean loginCheck(String sParaId, String sParaPasswd) {
		String sql = "SELECT role FROM userinfo WHERE id = ? AND passwd = ?";
		int iCnt = 0;
		
		conn = ConfigureImpl.getConnObject();
		
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
	
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sParaId);
			pstmt.setString(2, sParaPasswd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				++iCnt;
			}
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(iCnt >= 1) return true;
		else return false;
	}
}

