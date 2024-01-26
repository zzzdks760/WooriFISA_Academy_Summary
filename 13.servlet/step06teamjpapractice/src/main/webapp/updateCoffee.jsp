<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>기존 커피 수정</h2>
    <form action="coffees/update" method="POST">
        <label for="coffee-id">수정할 커피 id:</label>
        <input type="text" id="coffee-id" name="coffeeId">
        <label for="coffee-name">커피 이름:</label>
        <input type="text" id="coffee-name" name="coffeeName">
        <p>커피 사이즈 </p>
          <input type="radio" id="tall" name="coffeeSize" value="TALL">
          <label for="tall">TALL</label><br>
          <input type="radio" id="grande" name="coffeeSize" value="GRANDE">
          <label for="grande">GRANDE</label><br>
          <input type="radio" id="venti" name="coffeeSize" value="VENTI">
          <label for="venti">VENTI</label>
        <br /><br />
        <label for="coffee-price">가격:</label>
        <input type="number" id="coffee-price" name="coffeePrice">
        <br /><br />
        <button type="submit">수정하기</button>
    </form>
</body>
</html>