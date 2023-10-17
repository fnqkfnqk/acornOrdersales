package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.ordersales.comm.ConfigureImpl;

public class IdCheckDao {
	
	private static Connection conn = null;
	
	public static boolean IdCheck(String sParaId) {
		
		conn = ConfigureImpl.getConnObject();
		
		boolean result = false;
		String sql= "SELECT id FROM userinfo WHERE id=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;

		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sParaId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = true;
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		return result;
	}
	
}
