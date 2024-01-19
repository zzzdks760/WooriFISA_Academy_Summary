package dev.syntax.step03http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "firstHttpResponseServlet", urlPatterns = "/first-response-servlet")
public class FirstHttpResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HTTP 응답 메시지 작성 시 헤더에 기입할 내용 
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("custom-header", "my custom header info");
		
		PrintWriter out = response.getWriter();
		
		// <html></html> 생략
		out.print("Hello");
		out.close();
		
	}

}
