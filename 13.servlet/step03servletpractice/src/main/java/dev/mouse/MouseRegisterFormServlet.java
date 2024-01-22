package dev.mouse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Mouse 등록을 위한 입력 폼 화면을 응답하는 서블릿
 */
public class MouseRegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("	<head>");
		responseHTML.append("		<meta charset=\"UTF-8\"/>");
		responseHTML.append("		<title>Mouse 등록 페이지</title>");
		responseHTML.append("	</head>");
		responseHTML.append("		<body>");
		
		final String URL = "\"add\"";
		final String HTTP_METHOD = "\"POST\""; 
		
		String formAttribute = String.format("action=%s method=%s", URL, HTTP_METHOD);
		responseHTML.append("<h1>Mouse 등록 페이지</h1>");
		responseHTML.append("			<form " + formAttribute + ">");
		
		String nameInputAttribute = "type=\"text\" name=\"name\"";
		responseHTML.append("			name: <input " + nameInputAttribute + "><br/>");
		
		String countryInputAttribute = "type=\"text\" name=\"country\"";
		responseHTML.append("			country: <input " + countryInputAttribute + "><br/>");
		
		String addressInputAttribute = "type=\"text\" name=\"address\"";
		responseHTML.append("			address: <input " + addressInputAttribute + "><br/>");
		
		String buttonAttribute = "type=\"submit\"";
		responseHTML.append("			<button " + buttonAttribute + ">등록</button><br/>");
		responseHTML.append("		</body>");

		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		writer.write(responseHTML.toString());
	}

}
