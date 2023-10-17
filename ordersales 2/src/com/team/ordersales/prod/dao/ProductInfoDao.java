package com.team.ordersales.prod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.prod.entity.ProductInfoEntity;

public class ProductInfoDao {
	
	private static Connection conn = null;
	
	public static List<ProductInfoEntity> productshow(String sCategory) {
		String sql = "SELECT * FROM INSALESGOODS WHERE category = ?";
//		String sql = "SELECT I.goodsCode, I.goodsName, I.imgsource, I.category, S.RAWMATERIALQTY FROM INSALESGOODS.I STOCKINFO.S WHERE category = ?";
		
		List<ProductInfoEntity> llist = new ArrayList<ProductInfoEntity>(); 
		ProductInfoEntity pe = null;
		
		conn = ConfigureImpl.getConnObject();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sCategory);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				pe = new ProductInfoEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				llist.add(pe);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return llist;
	}
	
}
