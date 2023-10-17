<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
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
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }

        .in {
            margin-bottom: 10px;
        }

        #btn {
            background-color: #007bff;
            margin-bottom: 30px;
            color: white;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }
    </style>
</head>

<body>
    <div>
        <form action="/ordersales/logincheck" method="GET">
            <input type="text" placeholder="아이디" name="id" class="in">
            <input type="password" placeholder="비밀번호" name="passwd" class="in">
            <input type="submit" id="btn" value="로그인"><br>
        </form>
        <a href="/ordersales/views/login/registermember.jsp">회원 가입</a>
    </div>
</body>

</html>