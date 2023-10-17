package com.team.ordersales.sales.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateInsale {
	private final static String DB_URL =
			"jdbc:oracle:thin:@192.168.0.123:1521:xe";
	private final static String USER = "team1";
	private final static String PASS = "team1";

	public UpdateInsale() {}
	
	public static boolean getUpdate(String Goodscode, String insales) {
	    String sqlUpdate =  "update ORDERGOODS\r\n"
				+ "set INSALES = ?\r\n"
				+ "where GOODSCODE = ?";
	    
	    int flag = 0;
	    String editInsales = null;
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;

		try {
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        //orderGoods update
	        pstmt = conn.prepareStatement(sqlUpdate);
	        
	        if(insales.equals("n")) {editInsales = "y";}
	        if(insales.equals("y")) {editInsales = "n";}
	        
	        pstmt.setString(1, editInsales);
	        pstmt.setString(2, Goodscode);
			
			flag = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		if (flag > 0) {
			//성공
			return true;
		} else {
			//실패
			return false;
		}
	}
	
	public static boolean InsertInsales(String Goodscode) {
	   String sqlInsertInsales = "INSERT INTO INSALESGOODS i (SEQ, GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQTY, IMGSOURCE, CATEGORY)\n"
//			   + "SELECT (SELECT MAX(SEQ) + 1 FROM INSALESGOODS),GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQTY\n"
			   + "SELECT SEQ,GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQTY, IMGSOURCE, CATEGORY\n"
			   + "FROM ORDERGOODS o \n"
			   + "WHERE GOODSCODE = ?";
	   
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    int flag = 0;

	    try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        pstmt = conn.prepareStatement(sqlInsertInsales);
	        pstmt.setString(1, Goodscode);

	        flag = pstmt.executeUpdate();
	        
			pstmt.close();
			conn.close();
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		if (flag > 0) return true;
		else return false;
	}
	
	public static boolean DeleteInsales(String Goodscode) {
		String sqlDeleteInsales = "DELETE FROM INSALESGOODS WHERE GOODSCODE = ?";
		 
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    int flag = 0;

	    try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        pstmt = conn.prepareStatement(sqlDeleteInsales);
	        pstmt.setString(1, Goodscode);

	        flag = pstmt.executeUpdate();
	        
			pstmt.close();
			conn.close();

	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		if (flag > 0) return true;
		else return false;
	}

}
