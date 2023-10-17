package com.team.ordersales.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.ordersales.login.dao.IdCheckDao;
import com.team.ordersales.login.service.IdCheckService;
import com.team.ordersales.login.utils.ServletForward;

@WebServlet("/idcheck")
public class IdCheckController extends HttpServlet {
	
	public IdCheckController() {super();}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		boolean idCheck = IdCheckDao.IdCheck(id);
		
		new IdCheckService().IdCheck(id, idCheck, req);
		
		new ServletForward().pageForward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
