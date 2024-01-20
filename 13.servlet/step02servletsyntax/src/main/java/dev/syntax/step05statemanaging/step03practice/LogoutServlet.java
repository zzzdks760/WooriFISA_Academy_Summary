package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice-logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false); // 세션이 존재할때만 로그아웃을 수행하기 위해 false
		
		if (session != null && session.getAttribute("userId") != null) {
			session.invalidate();
			out.print("로그아웃 완료");
		} else {
			out.print("로그인 상태가 아닙니다.");
		}
		
		out.close();
	}
	
}
