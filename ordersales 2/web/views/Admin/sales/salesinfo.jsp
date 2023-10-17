<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매내역</title>
<style>
@import
   url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
   ;

body {
   font-family: 'Noto Sans KR', sans-serif; /* 폰트 변경 */
   background-color: #f0f0f0;
   margin: 0;
   padding: 0;
}

#main {
   display: flex;
   justify-content: center;
   flex-direction: column;
   align-items: center;
}

input[type="submit"] {
   background-color: #007bff;
   color: #fff;
}

#form1 {
   display: flex;
   justify-content: space-around;
}

#form1>div>* {
   border-radius: 10px;
   padding: 3px 10px;
   border: 1px #f0f0f0 thin;
   margin: 0px;
}

h1 {
   text-align: center;
   text-decoration: underline;
}

table {
   width: 90%; /* 테이블 너비 조정 */
   margin: 20px auto;
   border-collapse: collapse;
   background-color: #fff;
}

th, td {
   padding: 12px; /* 셀 패딩 조정 */
   text-align: center;
   border: 1px solid #ddd;
}

th {
   background-color: #007bff;
   color: #fff;
}

tr:nth-child(even) {
   background-color: #f2f2f2;
}
</style>
</head>
<body>
   <div id="main">
      <h1>판매내역</h1>
      <br>
      <form id="form1" action="/ordersales/salesinfo" method="get">
         <div>
            <label for="start_date">시작 날짜:</label> <input type="date"
               id="start_date" name="start_date" value="${vstartdate}">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
               for="end_date">종료 날짜:</label> <input type="date" id="end_date"
               name="end_date" value="${venddate}">
         </div>
         <div>
            <label for="search_text">검색:</label> <input type="text"
               id="search_text" name="search_text" value="${vsearchtext}">
            <input type="submit" value="적용">
            <input type="reset" value="돌아가기" onclick="location.href='/ordersales/views/Admin/adminmenu.jsp'">
         </div>
      </form>
      <br>
      <table border="1" width="100%">
         <tr>
            <th>상품 이름</th>
            <th>수량</th>
            <th>날짜</th>
         </tr>
         <c:forEach var="salesinfo" items="${salesinfolist}">
            <tr>
               <td>${salesinfo.goodsname}</td>
               <td>${salesinfo.orderquantity}</td>
               <td>${salesinfo.salesdate}</td>
            </tr>
         </c:forEach>
         <c:if test="${empty salesinfolist && not empty vstartdate}">      
             <script>
                 alert('검색결과가 없습니다.');
                 history.go(-1);
             </script>
         </c:if>
      </table>
   </div>

   <script>
</script>
</body>

</html>