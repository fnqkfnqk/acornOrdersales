<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 확인</title>
</head>
<body>

	<%	
		// result 값이 null 이거나 true/false
		Object result = request.getAttribute("idCheck");
		String userId =(String)request.getAttribute("id");
	%>

	<div id="wrap">
		ID 중복 확인
		<div id="chk">
			<%if (result==null){ %>
				<form action="/ordersales/idcheck" method="get">
					<input type="text" id="id" name="id" placeholder="중복 체크할 ID를 입력하세요">
					<input type="submit" value="중복 체크">
				</form>
			<%}else{ %>
				<form action="/ordersales/idcheck" method="get">
					<input type="text" id="id" name="id" value="<%=userId %>" placeholder="중복 체크할 ID를 입력하세요">
					<input type="submit" value="중복 체크">
				</form>
				<%if((boolean)result){ %>
					<span style="color:red">해당 ID는 이미 사용 중합니다.</span>
				<%}else{ %>
					<span style="color:blue">해당 ID는 사용이 가능합니다.</span>
					<button onclick="userId()">사용하기</button>
					<script>
						function userId(){
							window.opener.document.getElementById('id').value= document.getElementById('id').value;
							window.opener.document.getElementById('isCheck').value= "true";
							window.close();
						}
					</script>
				<%} %>	
			<%} %>
		</div>
	</div>
</body>
<script>
	function getID(){
		document.getElementById("id").value = window.opener.document.getElementById("id").value;
	}
</script>
</html>