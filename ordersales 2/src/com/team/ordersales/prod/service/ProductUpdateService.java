package com.team.ordersales.prod.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.prod.dao.ProductUpdateDao;
import com.team.ordersales.prod.entity.ProductInfoEntity;

public class ProductUpdateService {
	
	public void updateService(HttpServletRequest req, String sGoodsCode, String sCategory, String sAmount) {
		
		List<ProductInfoEntity> llist = ProductUpdateDao.productupdate(sGoodsCode, sCategory, sAmount);
		
		req.setAttribute("goodsList", llist);
		
		if(sCategory.equals("electronic")) {
			req.setAttribute("pageurl", "/productinfo?&category=electronic");
		}
		else if(sCategory.equals("fashion")) {
			req.setAttribute("pageurl", "/productinfo?&category=fashion");
		}
		else if(sCategory.equals("sports")) {
			req.setAttribute("pageurl", "/productinfo?&category=sports");
		}
		
	}
}
