package dev.syntax.step01helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 2. Annotation(@) 기반 맵핑
 * 
 * XML을 통한 관리 방식의 번거로움
 * 추상화되고 직관적인 Annotation 표기법으로 맵핑 처리를 간소화
 * 
 * @WebServlet
 * ref. https://javaee.github.io/javaee-spec/javadocs/javax/servlet/annotation/WebServlet.html
 * https://github.com/javaee/servlet-spec/blob/master/src/main/java/javax/servlet/annotation/WebServlet.java
 */
@WebServlet(name = "MySecondServlet", urlPatterns = "/servlets/secondservlet")
public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8"); // 응답 헤더에 Content-Type: text/html 헤더 추가
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Second Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
	}
	
}
