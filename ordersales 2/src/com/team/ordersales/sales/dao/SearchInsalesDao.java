package com.team.ordersales.sales.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.team.ordersales.order.dto.IdentifyInsalesDto;

public class SearchInsalesDao {
	private final static String DB_URL =
			"jdbc:oracle:thin:@192.168.0.123:1521:xe";
	private final static String USER = "team1";
	private final static String PASS = "team1";
		
	public static List<IdentifyInsalesDto> getSearch(String searchField, String searchText) {
	    List<IdentifyInsalesDto> list = new ArrayList<IdentifyInsalesDto>();
	    IdentifyInsalesDto iid = null;

	    String sqlSearchSale = "SELECT GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQTY, INSALES " +
	            "FROM ORDERGOODS WHERE " + searchField.trim() + " LIKE '%' || ? || '%' " +
	            "ORDER BY GOODSCODE DESC";
	   
	   // 여기서 한글을 입력하면 '%ì£¼ë¬¸%'이렇게 나와서 

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        pstmt = conn.prepareStatement(sqlSearchSale);
	        pstmt.setString(1, searchText.trim());
	        
	        rs = pstmt.executeQuery(); // Execute the query
	        
	        System.out.println(sqlSearchSale);

	        while (rs.next()) {
	            iid = new IdentifyInsalesDto();

	            iid.setGOODSCODE(rs.getString("GOODSCODE"));
	            iid.setGOODSNAME(rs.getString("GOODSNAME"));
	            iid.setINSALES(rs.getString("INSALES"));
	            iid.setRAWMATERIALCODE(rs.getString("RAWMATERIALCODE"));
	            iid.setRAWMATERIALQTY(rs.getInt("RAWMATERIALQTY"));

	            list.add(iid);
	            
	            System.out.println(iid);
	        }

	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}
	
