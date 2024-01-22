package dev.mouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.dao.MouseDAO;
import dev.mouse.model.Mouse;

/*
 * 전체 Mouse 목록을 리스트 형태로 출력하는 서블릿
 * 
 * DB에서 전체 Mouse 목록을 가져와서 화면에 출력하는 역할 수행
 */
@WebServlet("/mice")
public class MouseListServlet extends HttpServlet {

	private final MouseDAO mouseDAO;

	public MouseListServlet() {
		this.mouseDAO = new MouseDAO();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// DB에서 조회하는 로직
		List<Mouse> mice = mouseDAO.findAll();

		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("	<head>");
		responseHTML.append("		<title>Mouse 목록 페이지</title>");
		responseHTML.append("	</head>");
		responseHTML.append("	<body>");
		responseHTML.append("<h1>Mouse 목록 페이지</h1>");

		// Mouse 데이터 출력 로직, html 태그 작성 부분(ex. Mouse 목록 작성을 위한 <ul>, <li>태그 등)
		responseHTML.append("<ul>");

		String liStyle = "style=\"display:flex; list-style:none;\"";
		for (Mouse mouse : mice) {
			responseHTML.append("<li " + liStyle + ">");
			responseHTML.append(String.format("<div>%s</div>", mouse.getId()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getName()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getCountry()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getAddress()));
			responseHTML.append("</li>");

		}
		responseHTML.append("</ul>");

		responseHTML.append("	</body>");
		responseHTML.append("		</html>");
		
		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		writer.write(responseHTML.toString());
	}

}
