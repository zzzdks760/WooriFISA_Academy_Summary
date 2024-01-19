package dev.syntax.step03http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url 경로 - /first-request-servlet
@WebServlet(urlPatterns = "/first-request-servlet")
public class FirstHttpRequestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("request: " + request);
		System.out.println("response: " + response);
		
		response.setContentType("text/html; charset=UTF-8");
		// Header 메시지 담긴 정보 추출
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Request Information Example</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h3>요청 메시지에 담긴 정보 확인</h3>");
		
		// Header 메시지에 담긴 정보 추출
		out.println("Context Path : " + request.getContextPath() + "<br/>");
		out.println("Request URL : " + request.getRequestURL() + "<br/>");
		out.println("Request URI : " + request.getRequestURI() + "<br/>");
		out.println("Server Port : " + request.getServerPort() + "<br/>");
		out.println("Request Protocol : " + request.getProtocol() + "<br/>");
		out.println("Request METHOD: " + request.getMethod() + "<br/>");
		out.println("Query String : " + request.getQueryString() + "<br/>");// http://localhost:8080/step03newsyntax/first-request-servlet?name=jerry&age=15
		out.println("Parameter(name) : " + request.getParameter("name") + "<br/>");
		out.println("Parameter(age) : " + request.getParameter("age") + "<br/>");
		
		out.println("</body>");
        out.println("</html>");
        
		out.close();
		
		
		
		
	}

}