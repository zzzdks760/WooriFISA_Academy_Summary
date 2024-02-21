<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 가능한 코트 목록</title>
</head>
<body>
	<form action="tennis/reserve" method="GET" id="form">
		<div>
			<label for="center-name">테니스 구장 선택</label>
			<select name="center" id="center-name">
				<option value="YCS">양천 센터</option>
				<option value="KSS">강서 센터</option>
				<option value="MDS">목동 센터</option>
			</select>
		</div>
		<div>
			<input type="radio" name="court" value="1"> 1번 코트
			<input type="radio" name="court" value="2"> 2번 코트
			<input type="radio" name="court" value="3"> 3번 코트
		</div>
		<div>
			<label for="datetime">예약할 날짜와 시간을 선택하세요:</label>
			<input type="datetime-local" id="datetime" name="datetime" required>
		</div>
		<input type="submit" value="예약하기" />
	</form>
</body>
</html>