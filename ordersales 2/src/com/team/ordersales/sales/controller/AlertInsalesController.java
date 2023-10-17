package com.team.ordersales.sales.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.sales.service.EditInsaleService;

@WebServlet("/alertInsale")
public class AlertInsalesController  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 0. 문자셋 설정
		req.setCharacterEncoding("UTF-8");
		
		// 요청 매개변수로부터 값을 가져옵니다
        String goodsCode = req.getParameter("goodsCode");
        String insales = req.getParameter("insales");
		
        System.out.println(goodsCode);
        System.out.println(insales);
        
		// 2. 데이터 베이스 - 서비스코드
		new EditInsaleService().InsertInsale(req, goodsCode, insales);	
		
		// 3. JSP 페이지 호출 (변경사항을 나타내주기 위해 리다이렉트함)
		resp.sendRedirect("/ordersales/insaleList"); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
