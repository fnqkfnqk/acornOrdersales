<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <style>
    	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        body {
            background-color: #007bff;
        }
        
		div {
            margin: auto;
            width: fit-content;
            background-color: #EEEFF1;
            border-radius: 5px;
            padding: 20px;
        }
        
        #buttons{
        	text-align: center;
        }
        
	    form {
	      width: 600px;
	      margin: auto;
	    }
	    form legend {
	      font-size: 20px;
	      text-align: center;
	    }
	    form p span {
	      font-size: 13px;
	      color: rgb(0, 60, 255);
	      font-style: italic;
	    }
	</style>
	
	<script>
	function idCheck(){
		childWindow = window.open("/ordersales/views/login/IdCheckForm.jsp","_blank","width=100px height=50px");
		childWindow.document.getElementById('id').value = document.getElementById('id').value;
	}

	function check(){
		
		var idCk = document.getElementById('isCheck').value;
		var pw1 = document.getElementById('passwd').value;
		var pw2 = document.getElementById('passwd2').value;
		
		if(idCk=="false"){
			alert("ID 중복확인을 진행해주세요.");
			return false;
		}
		
		if(pw1.length < 6){
			alert("비밀번호는 6자리 이상이여야 합니다.");
			return false;
		}
		
		if(pw1!=pw2){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		return true;
	}
	</script>
</head>


<body>	
	<div>
		<form action="/ordersales/regimem" method="GET" onsubmit='return check();'>
		  <fieldset>
		    <legend>회원가입</legend>
		    <p>
				<label>아이디</label>
				<input type="text" id="id" name="id" onkeydown="inputIdChk()" required/>
				<input type="button" name="checkID" value="아이디 확인" onclick="idCheck()">
				<input type="hidden" id="isCheck" name="isCheck" value="false"/>
				<br>
		    </p>
		    <p>
				<label>비밀번호</label>
				<input type="text" id="passwd" name="passwd" required>
		      	<br>
		    </p>
		    <p>
		      	<label>비밀번호 확인</label>
				<input type="text" id="passwd2" name="passwd2" required>
		     	<br>
		    </p>
		    <p>
		      <label>핸드폰 번호</label>
		      <input type="text" name="phonenum" required>
		      <br>
		    </p>
		    <p>
		      <label>주소</label>
		      <input type="text" name="addr" required>
		      <br>
		    </p>
		  </fieldset>
		  <div id="buttons">
		  	<input type="submit" id="regist" value="회원가입">
		  	<input type="reset" value="다시 입력하기">
		  </div>
		</form>
	</div>
</body>
</html>