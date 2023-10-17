package com.team.ordersales.sales.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.team.ordersales.login.utils.ServletForward;
import com.team.ordersales.sales.service.SalesInfoService;

@WebServlet("/salesinfo")
public class SalesInfoController extends HttpServlet {

   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // 0. 문자셋 설정
      req.setCharacterEncoding("UTF-8");
      // 1. 사용자 입력 처리
      String sParaSD = req.getParameter("start_date");
      String sParaED = req.getParameter("end_date");
      String sParaST = req.getParameter("search_text");
      if (sParaSD == "" || sParaED == "") {
         sParaSD =LocalDate.now().toString();
         sParaED =LocalDate.now().toString();
      };
      
      // 2. 데이터 베이스 - 서비스코드
      new SalesInfoService().SalesInfoDate(sParaSD, sParaED, sParaST, req);
      // 3. JSP 페이지 호출
      new ServletForward().pageForward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }
}