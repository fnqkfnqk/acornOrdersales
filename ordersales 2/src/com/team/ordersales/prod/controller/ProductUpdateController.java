package com.team.ordersales.prod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.utils.ServletForward;
import com.team.ordersales.prod.service.ProductUpdateService;

@WebServlet("/produpdate")
public class ProductUpdateController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String sGoodsCode = req.getParameter("goodscode");
		String sCategory = req.getParameter("category");
		String sAmount = req.getParameter("amount");
		
		new ProductUpdateService().updateService(req, sGoodsCode, sCategory, sAmount);
		
		new ServletForward().pageForward(req, resp); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
