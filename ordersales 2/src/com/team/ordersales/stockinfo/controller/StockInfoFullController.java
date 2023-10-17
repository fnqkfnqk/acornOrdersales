package com.team.ordersales.stockinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.utils.ServletForward;
import com.team.ordersales.stockinfo.service.StockInfoFullService;

@WebServlet("/stockinfo4")
public class StockInfoFullController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String sCode = req.getParameter("rawmaterialcode");
		
		new StockInfoFullService().stockInfoFull(req, sCode);
		
		new ServletForward().pageForward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
