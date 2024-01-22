package dev.syntax.step06forwardredirext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page2")
public class RequestDispatcherServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int age = (Integer)req.getAttribute("age");
		System.out.println(age);
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<h3>forward의 Servlet message</h3>");
		
		System.out.println("forward된 서블릿 실행");
				
		out.close();
	}

}
