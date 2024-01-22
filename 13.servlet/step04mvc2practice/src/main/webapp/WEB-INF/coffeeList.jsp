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