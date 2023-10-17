package com.team.ordersales.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.ordersales.login.service.LoginCheckService;
import com.team.ordersales.login.utils.ServletForward;

@WebServlet("/logincheck")
public class LoginCheckController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 0. 문자셋 설정
		req.setCharacterEncoding("UTF-8");
		
		// 1. 사용자 입력 처리
		String sParaId = req.getParameter("id");
		String sParaPasswd = req.getParameter("passwd");
		
		// 2. 데이터 베이스 - 서비스코드
		new LoginCheckService().
		loginCheck(sParaId, sParaPasswd, req);
		
		session.setAttribute("id", sParaId);
		
		// 3. JSP 페이지 호출
		new ServletForward().pageForward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
