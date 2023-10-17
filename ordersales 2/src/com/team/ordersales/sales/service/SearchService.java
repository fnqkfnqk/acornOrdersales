package com.team.ordersales.sales.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.order.dto.IdentifyInsalesDto;
import com.team.ordersales.sales.dao.SearchInsalesDao;

public class SearchService {
	
	public void SearchInsaleList(HttpServletRequest req, String searchField, String searchText) {
		
		List<IdentifyInsalesDto> lala = SearchInsalesDao.getSearch(searchField, searchText);
		
		req.setAttribute("searchInsalelist", lala);
		req.setAttribute("pageurl",
				"/views/Admin/insale/searchInsales.jsp");
	}
}
