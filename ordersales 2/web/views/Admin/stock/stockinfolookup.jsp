<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');
	
	h1 {
        text-align: center;
        text-decoration: underline;
        
    }
    
	body {
		background-color: #f0f0f0;
		font-family: Arial, sans-serif;
		font-size: 16px;
		font-weight: 300px;
		text-rendering: optimizeLegibility;
		margin: 0;
		padding: 0;
	}

	table {
        width: 80%;
        margin: 10px auto;
        border-collapse: collapse;
        background-color: #fff;
    }

    th, td {
        padding: 10px;
        text-align: center;
        border: 1px solid #ddd;
    }
    
    a{
    	color: black;
    }

    th {
        background-color: #007bff;
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

	#btn {
		width: 150px;
		height: 100px;
		font-size: 16px;
		border-radius: 10px;
		background-color: #cb99c5;
		color: white;
		margin: 50px;
		text-align: center;
		justify-content: center;
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
<head>
<meta charset="UTF-8">
<title>재고 조회</title>
</head>
<body>
	
	<%
		String id = (String)session.getAttribute("id");
	%>
	
	<div id=headerWrap>
		<div id="header1"></div>
		<div>
			<a href="/ordersales/views/Admin/adminmenu.jsp"><h1> 관리자 메뉴 - 재고 조회 </h1></a>
		</div>
		<div id=header2>
			<span><strong><%= id %> | </strong></span>
			<span id="logout" onclick="location.href='/ordersales/views/login/logout.jsp'" >  로그아웃</span>
		</div>
	</div> 
	<div>
	<form action = '/ordersales/stockinfosearch' method = 'get' id='search-box'>
		<label for = 'category'></label>
		<select name = 'searchplace' id='category'>
			<option value=''>카테고리 선택 </option>
			<option value='electronic'>전자제품</option>
			<option value='sports'>스포츠</option>
			<option value='fashion'>의류</option>
			<option value='toy'>장난감</option>
		</select>
		<input type = 'text' maxlength="100" placeholder="검색어 입력" name='searchtext' />
		<button type = 'submit'>검색</button>
	</form>

	<table>
		<tr>
			<th class="text-left">재고 이름</th>
			<th class="text-left">재고 수량</th>
			<th class="text-left">재고 코드</th>
			<th class="text-left">채우기</th>
		</tr>
		<c:forEach var="stockInfo" items="${stockinfo}">
			<tr>
				<td class="text-left">${stockInfo.rawmaterialname}</td>
				<td class="text-left">${stockInfo.rawmaterialqty}</td>
				<td class="text-left">${stockInfo.rawmaterialcode}</td>
				<td>
					<form action="/ordersales/stockinfo4" method="get" onsubmit="return isfill()">
						<input type='submit' value='채우기' id='full-btn'/>
						<input type='hidden' value="${stockInfo.rawmaterialcode}" name="rawmaterialcode" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<form action="/ordersales/stockinfo4" method="get" onsubmit="return isfill()" id='btn-form'>
		<input type='submit' value='전체 채우기' id="btn" />
		<input type='hidden' value="all" name="rawmaterialcode" />
	</form>	
</div>
</body>
<script>
	function isfill(){
		if(confirm("재고 수량을 가득 채우시겠습니까?")){
			alert("재고 수량을 가득 채웠습니다");
			return true;
		}else{
			alert("명령을 취소했습니다.");
			return false;
		}
	}
</script>
</html>