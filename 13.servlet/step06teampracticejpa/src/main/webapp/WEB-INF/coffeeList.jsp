<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>사이즈</th>
			<th>가격</th>
		</tr>

		<!-- 템플릿 로직 작성 부분 -->

		<!-- for todo in todos -->
		<c:choose>
			<!-- 요청 객체(request) 내에서 "list"라는 이름의 key값을 조회하면,
				List<coffees> coffees를 취득
				
				var - 반복문 내에서 사용할 임시 변수 이름
			 -->
			<c:when test="${empty requestScope.list || fn:length(list) == 0}">
				<tr>
					<td>등록된 커피 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.list}" var="coffee">
					<tr>
						<td>${coffee.id}</td>
						<td>${coffee.name}</td>
						<td>${coffee.size}</td>
						<td>${coffee.price}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>