package dev.starbar.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.UserDAO;

@WebServlet("/practice-register")
public class UserRegisterController extends HttpServlet{
	
	private UserDAO userDAO;

	public UserRegisterController() {
		this.userDAO = new UserDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step06teamjpapractice");
		System.out.println(factory);
//		res.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = res.getWriter();
//		
//		String id = req.getParameter("id");
//		String password = req.getParameter("password");
//		
//		boolean result = userDAO.save(id, password);
//		
//		if (result) {
//			res.sendRedirect(req.getContextPath()+"/index.html");
//		} else {
//			out.println("로그인 실패");
//		}
//		out.close();
	}
	
}
