package com.team.ordersales.login.service;

import javax.servlet.http.HttpServletRequest;

import com.team.ordersales.login.dao.RegisMemDao;
import com.team.ordersales.login.dto.RegisMemDto;

public class RegisMemService {

	public void registerMember(RegisMemDto regisMemDto,
			HttpServletRequest req) {
		if(RegisMemDao.registerMember(regisMemDto)) {
			req.setAttribute("pageurl", 
					"/views/login/registersuccess.jsp");	
			req.setAttribute("id", regisMemDto.getId());
			req.setAttribute("message", "가입성공!!!");
		} else {
			req.setAttribute("pageurl", 
					"/views/login/registerfail.jsp");	
			req.setAttribute("id", regisMemDto.getId());
			req.setAttribute("message", "가입실패!!!");
		}
	}
}