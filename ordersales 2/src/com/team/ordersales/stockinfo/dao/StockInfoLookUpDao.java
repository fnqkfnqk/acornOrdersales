package com.team.ordersales.stockinfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.stockinfo.entity.StockInfoEntity;

public class StockInfoLookUpDao {
	// 쿼리문 - 재고 테이블이랑 정보 테이블에서 이름과 수량을 뽑아오는 명령문. 조회창에 이름 - 수량 으로 나올 수 있게
	private static String QUERY1 = "select r.rawmaterialname, o.rawmaterialqty, o.rawmaterialcode from rawmaterial r, stockinfo o where r.rawmaterialcode = o.rawmaterialcode";


	public static ArrayList<StockInfoEntity> getStockInfoList() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = null;
		Connection conn = ConfigureImpl.getConnObject();
		stmt = conn.createStatement();
		ResultSet rs = null;

		ArrayList<StockInfoEntity> silist = new ArrayList<StockInfoEntity>();
		StockInfoEntity le = null;


		rs = stmt.executeQuery(QUERY1);
		while (rs.next()) {
			String siName = rs.getString("rawmaterialname");
			String siQty = rs.getString("rawmaterialqty");
			String siCode = rs.getString("rawmaterialcode");

			le = new StockInfoEntity(siName, siQty, siCode);
			silist.add(le);
		}
		rs.close();
		stmt.close();

		return silist;
	}

}
