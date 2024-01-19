package dev.syntax.step04querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-eng")
public class QueryServletEng extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("GET 호출");
		
		res.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		String[] hobby = req.getParameterValues("hobby");
		
		String gender = req.getParameter("gender");
		
		String country = req.getParameter("country");
		
		String introduction = req.getParameter("introduction");
		
		PrintWriter out = res.getWriter();
		
		out.println("id: " + id);
		out.println("password: " + password);
		out.println("name: " + name);
		
		for (String s : hobby) {
			if (s != null) {
				out.print(s + " ");
			}
		}
		
		out.println("gender: " + gender);
		out.println("country: " + country);
		out.println("introduction: " + introduction);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("POST 호출");
		
		res.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		String[] hobby = req.getParameterValues("hobby");
		
		String gender = req.getParameter("gender");
		
		String country = req.getParameter("country");
		
		String introduction = req.getParameter("introduction");
		
		PrintWriter out = res.getWriter();
		
		out.println("id: " + id);
		out.println("password: " + password);
		out.println("name: " + name);
		
		for (String s : hobby) {
			if (s != null) {
				out.print(s + " ");
			}
		}
		
		out.println("gender: " + gender);
		out.println("country: " + country);
		out.println("introduction: " + introduction);
	}

	
}
