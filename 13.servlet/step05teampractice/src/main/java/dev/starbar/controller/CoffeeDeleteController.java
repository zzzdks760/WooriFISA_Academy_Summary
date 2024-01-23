package dev.starbar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;

@WebServlet("/coffees/delete")
public class CoffeeDeleteController extends HttpServlet{

	private CoffeeDAO coffeeDAO;
	
	public CoffeeDeleteController() {
		this.coffeeDAO = new CoffeeDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String delId = req.getParameter("delId");
		int id = Integer.parseInt(delId);
		
		boolean result = coffeeDAO.deleteById(id);
		
		if (result) {
			resp.sendRedirect(req.getContextPath() + "/home.html");
		} else {
			out.print("삭제 실패");
		}
		out.close();
	}
	
}
