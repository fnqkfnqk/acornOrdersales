package com.team.ordersales.stockinfo.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.stockinfo.dao.StockInfoSearchDao;
import com.team.ordersales.stockinfo.entity.StockInfoEntity;

public class StockInfoSearchService {

	public void stockInfoSearch(HttpServletRequest req, String searchplace, String serchtext) {
		List<StockInfoEntity> sList = null;
		try {
			sList = StockInfoSearchDao.getStockInfoSearchList(searchplace, serchtext);
			req.setAttribute("stockinfo", sList);
			req.setAttribute("pageurl", "/views/Admin/stock/stockinfolookup.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
