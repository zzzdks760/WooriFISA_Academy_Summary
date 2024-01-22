package dev.syntax.step06forwardredirext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class RequestDispatcherServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<h3>Dispatcher Servlet 수행 결과</h3>");
		
		String name = req.getParameter("name");
		
		req.setAttribute("age", 5);
		
		
		RequestDispatcher rdp = req.getRequestDispatcher("/page2");
		rdp.forward(req, res);
		
		out.close();
	}

}
