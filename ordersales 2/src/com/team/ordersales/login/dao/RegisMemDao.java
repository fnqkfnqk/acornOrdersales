package com.team.ordersales.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.login.dto.RegisMemDto;

public class RegisMemDao {
	
	private static Connection conn = null;
	
	public static boolean registerMember(RegisMemDto regisMemDto) {
		
		conn = ConfigureImpl.getConnObject();
		
		int iICount = 0;
			
		String sqlIns = "INSERT INTO userinfo(id, passwd, phonenum, role, addr)"
				+ "VALUES(?, ?, ?, ?, ?)";
	
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sqlIns);
			pstmt.setString(1, regisMemDto.getId());
			pstmt.setString(2, regisMemDto.getPasswd());
			pstmt.setString(3, regisMemDto.getPhonenum());
			pstmt.setString(4, regisMemDto.getRole());
			pstmt.setString(5, regisMemDto.getAddr());
				
			iICount = pstmt.executeUpdate();
			conn.commit();				
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		if(iICount == 1) return true;
		else return false;
	}
}

