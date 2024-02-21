<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>예매에 성공하였습니다!</h2>
	<div>
		<h3>예매 번호 ${reservation.id}</h3>
		<p>테니스 구장 : ${reservation.centerName}</p>
		<p>코트 번호 : ${reservation.courtNumber}</p>
		<p>예매 시간: ${reservation.reservedTime}</p>
	</div>
</body>
</html>