package dev.starbar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.starbar.dao.UserDAO;

@WebServlet("/practice-login")
public class LoginController extends HttpServlet{

	private UserDAO userDAO;
	
	public LoginController() {
		this.userDAO = new UserDAO();
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		boolean result = userDAO.findUser(id, password);
		
		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) {
			if (result) {				
				session.setAttribute("id", id);
				res.sendRedirect(req.getContextPath()+"/home.html");
			} else {
				out.print("로그인 실패");
			}
		} else {
			out.print("이미 로그인 중 입니다.");
		}
		out.close();
	}

}
