package dev.syntax.step05statemanaging.step01cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read-cookie")
public class ReadCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		
//		Cookie cookie = new Cookie("cookieName", "cookieValue");
		PrintWriter out = res.getWriter();
		
		for (Cookie cookie : req.getCookies()) {
			out.println(cookie.getName());
			out.println(cookie.getValue());
		}
	}

}
