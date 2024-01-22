package dev.mouse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 전체 Mouse 목록을 리스트 형태로 출력하는 서블릿
 * 
 * DB에서 전체 Mouse 목록을 가져와서 화면에 출력하는 역할 수행
 */
public class MouseListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에서 조회하는 로직
		
		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("	<head>");
		responseHTML.append("		<title>Mouse 목록 페이지</title>");
		responseHTML.append("	</head>");
		responseHTML.append("	<body>");
		responseHTML.append("<h1>Mouse 목록 페이지</h1>");
		
		// Mouse 데이터 출력 로직, html 태그 작성 부분(ex. Mouse 목록 작성을 위한 <ul>, <li>태그 등)
		
		responseHTML.append("	</body>");
		responseHTML.append("		</html>");
		
		PrintWriter writer = response.getWriter();
		writer.write(responseHTML.toString());
	}

}
