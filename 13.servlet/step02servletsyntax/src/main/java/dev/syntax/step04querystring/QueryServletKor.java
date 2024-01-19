package dev.syntax.step04querystring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-kor")
public class QueryServletKor extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("GET 호출");
		
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String parameter = req.getParameter("name");
		
		String parameter2 = req.get
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("POST 호출");
	}

	
}
