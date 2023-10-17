package com.team.ordersales.login.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForward {
	
	public void pageForward(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// dispatcher 얻기
		RequestDispatcher dispatcher =
				req.getRequestDispatcher(
						req.getAttribute("pageurl")
						.toString()
						);
		req.removeAttribute("pageurl");
		
		// jsp 이동
		dispatcher.forward(req, resp);
	}
}
