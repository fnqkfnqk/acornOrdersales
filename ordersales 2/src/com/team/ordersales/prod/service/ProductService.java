package com.team.ordersales.prod.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.prod.dao.ProductInfoDao;
import com.team.ordersales.prod.entity.ProductInfoEntity;

public class ProductService {
	
	public void productShow(HttpServletRequest req, String sCategory) {
		
		List<ProductInfoEntity> llist = ProductInfoDao.productshow(sCategory);
		
		req.setAttribute("goodsList", llist);
		
		if(sCategory.equals("electronic")) {
			req.setAttribute("pageurl", "/views/User/electronic/electronic.jsp");
		}
		else if(sCategory.equals("fashion")) {
			req.setAttribute("pageurl", "/views/User/fashion/fashion.jsp");
		}
		else if(sCategory.equals("sports")) {
			req.setAttribute("pageurl", "/views/User/sports/sports.jsp");
		}
		else if(sCategory.equals("toy")) {
			req.setAttribute("pageurl", "/views/User/toy/toy.jsp");
		}
		
		
	}
}
