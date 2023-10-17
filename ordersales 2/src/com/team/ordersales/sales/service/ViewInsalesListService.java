package com.team.ordersales.sales.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.order.dto.IdentifyInsalesDto;
import com.team.ordersales.sales.dao.InsalesDao;

public class ViewInsalesListService {
	
	public void ViewInsaleList(HttpServletRequest req) {
//		InsalesDao.getsaleList();
		List<IdentifyInsalesDto> lala = InsalesDao.getsaleList();
		req.setAttribute("insalelist", lala);
		req.setAttribute("pageurl", 
				"/views/Admin/insale/listInsales.jsp");

	}
}
