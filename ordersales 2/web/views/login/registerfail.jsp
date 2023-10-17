<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 결과</title>
    <style>
        div {
            margin: auto;
            width: 300px;
            background-color: white;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }
    </style>
</head>

<body>
    <div>
		<h1>${id}님! ${message}</h1>
		<a href="/ordersales/main.jsp">메인으로</a>
    </div>
</body>

</html>