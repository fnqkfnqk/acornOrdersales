package com.team.ordersales.stockinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.stockinfo.entity.StockInfoEntity;

public class StockInfoSearchDao {

	public static List<StockInfoEntity> getStockInfoSearchList(String searchplace, String searchtext) throws SQLException {
		List<StockInfoEntity> sList = new ArrayList<StockInfoEntity>();
		StockInfoEntity searchList = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String search = "select r.rawmaterialname, o.rawmaterialqty, o.rawmaterialcode\r\n" + 
				"from rawmaterial r \r\n" + 
				"inner join stockinfo o on r.rawmaterialcode = o.rawmaterialcode and o.category= ?\r\n" + 
				"where r.rawmaterialname\r\n" + 
				"LIKE '%'||?||'%'";

		Connection conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		pstmt = conn.prepareStatement(search);
		
		pstmt.setString(1, searchplace);
		pstmt.setString(2, searchtext);
		rs = pstmt.executeQuery();

		System.out.println(search);

		while (rs.next()) {
			searchList = new StockInfoEntity();
			String siName = rs.getString("rawmaterialname");
			String siQty = rs.getString("rawmaterialqty");
			String siCode = rs.getString("rawmaterialcode");
			searchList = new StockInfoEntity(siName, siQty, siCode);
			sList.add(searchList);
		}
		rs.close();
		pstmt.close();

		return sList;
	}
}
