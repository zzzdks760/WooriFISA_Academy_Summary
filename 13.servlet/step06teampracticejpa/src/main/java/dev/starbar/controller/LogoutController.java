package dev.starbar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice-logout")
public class LogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false); // 세션이 존재할때만 로그아웃을 수행하기 위해 false
		
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			resp.sendRedirect("index.html");
			System.out.println("로그아웃");
		} else {
			out.print("로그인 상태가 아닙니다.");
		}
		
		out.close();
	}
	
}
