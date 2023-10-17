<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        text-decoration: underline;
        
    }
	table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
    }

    th, td {
        padding: 10px;
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
    
    a{
    	color: black;
    }
    
    #headerWrap{
    	display: flex;
    	justify-content: space-between;
    }
    #header1, #header2{
    	width: 200px;
    	margin: 10px;
    }

</style>
</head>
<body>
	
	<%
		String id = (String)session.getAttribute("id");
		String center = request.getParameter("center");
	%>
	
	<div id=headerWrap>
		<div id="header1"></div>
		<div>
			<a href="/ordersales/views/User/usermenu.jsp" ><h1> JinDoBay - 패션 </h1></a>
		</div>
		<div id=header2>
			<span><strong><%= id %> | </strong></span>
			<span id="logout" onclick="location.href='/ordersales/views/login/logout.jsp'" >  로그아웃</span>
		</div>
	</div>
	
	<div>
		<table border="1">
			<tr>
             	<!-- <th><input type="checkbox" name="selectProd"></th> -->
                <th>상품 사진</th>
                <th>상품 이름</th>
                <th>수량</th>
                <th>구매</th>
            </tr>
            
            <c:forEach var="goodsList" items="${goodsList}">
				<tr>
					<td>
						<img src= "${goodsList.imgsource}" width="100" height="100" alt="${goodsList.goodsName}">
					</td>
					<td>${goodsList.goodsName}</td>
					<td>${goodsList.RAWMATERIALQTY}</td>
					<td>
						<form action="/ordersales/produpdate" method="GET" onsubmit="return isbuy();">
							<input type="submit" id="buyBtn" name="buyBtn" value="구매">
							<input type="hidden" name="goodscode" value="${goodsList.goodsCode}">
							<input type="hidden" name="category" value="fashion">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
	function isbuy(){
		if(confirm("상품을 구매하시겠습니까?")){
			alert("정상적으로 구매되었습니다.");
			return true;
		}else{
			alert("구매를 취소했습니다.");
			return false;
		}
	}
</script>
</html>