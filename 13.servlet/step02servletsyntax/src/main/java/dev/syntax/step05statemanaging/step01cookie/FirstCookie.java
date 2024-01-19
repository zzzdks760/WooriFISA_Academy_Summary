package dev.syntax.step05statemanaging.step01cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first-cookie-set")
public class FirstCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		
		Cookie cookie = new Cookie("id", "guest");
		res.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("nickName", "spiderman");
		cookie2.setMaxAge(30); // 3600초 * 3 = 1시간
		
		
		PrintWriter out = res.getWriter();
		out.println("서버에서 생성한 쿠키가 클라이언트로 전송되었음");
		out.close();
	}
	
}
