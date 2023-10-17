package com.team.ordersales.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.sales.entity.SalesInfoEntity;

public class SalesInfoDao {

	public static List<SalesInfoEntity> getSalesInfoList(String sParaSD,String sParaED,String sParaST) {
		List<SalesInfoEntity> llist = new ArrayList<SalesInfoEntity>();
		SalesInfoEntity le = null;

		String sqlsalesinfo = "select o.goodsname,s.orderqty,s.salesdate\r\n" + 
				"from ordergoods o\r\n" + 
				"join salesinfo s\r\n" + 
				"on s.goodscode = o.goodscode\r\n" + 
				"and s.salesdate between TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') and TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')\r\n" + 
				"where o.goodsname\r\n" + 
				"Like '%'||?||'%'\r\n" + 
				"order by s.salesdate,o.goodsname ASC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    sParaSD = sParaSD + " 00:00:00";
	    sParaED = sParaED + " 23:59:59";
		try {
			conn = ConfigureImpl.getConnObject();
			pstmt = conn.prepareStatement(sqlsalesinfo);
			pstmt.setString(1, sParaSD);
			pstmt.setString(2, sParaED);
			pstmt.setString(3, sParaST);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				le = new SalesInfoEntity(rs.getString(1), rs.getString(2), rs.getString(3));
				llist.add(le);
			}

			rs.close();
			pstmt.close();
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llist;
	}

}
