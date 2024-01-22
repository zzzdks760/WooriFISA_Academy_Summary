package dev.syntax.step06forwardredirext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other-site")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String site = req.getParameter("site");

		if (site.equals("naver")) {
			resp.sendRedirect("http://www.naver.com");
		} else if (site.equals("google")) {
			resp.sendRedirect("http://www.google.com");
		}
	}
}
