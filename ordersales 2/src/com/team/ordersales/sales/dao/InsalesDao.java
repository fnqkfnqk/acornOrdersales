package com.team.ordersales.sales.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.ordersales.comm.ConfigureImpl;
import com.team.ordersales.order.dto.IdentifyInsalesDto;

public class InsalesDao {
	
	private static Connection conn = null;
	
	public InsalesDao() {}
	
	public static List<IdentifyInsalesDto> getsaleList(){
		List<IdentifyInsalesDto> oList = new ArrayList<IdentifyInsalesDto>();
		IdentifyInsalesDto iid = null;
		
		String sqlSale = "SELECT GOODSCODE, GOODSNAME, RAWMATERIALCODE, RAWMATERIALQTY, INSALES\r\n"
				+ "from ORDERGOODS order by GOODSCODE desc";
		
		conn = ConfigureImpl.getConnObject();
		
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		
		try {

			pstmt = conn.prepareStatement(sqlSale);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				iid = new IdentifyInsalesDto();
				
				iid.setGOODSCODE(rs.getString("GOODSCODE"));
				iid.setGOODSNAME(rs.getString("GOODSNAME"));
				iid.setINSALES(rs.getString("INSALES"));
				iid.setRAWMATERIALCODE(rs.getString("RAWMATERIALCODE"));
				iid.setRAWMATERIALQTY(rs.getInt("RAWMATERIALQTY"));
				
				oList.add(iid);
				
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	 return oList;
	}
}
