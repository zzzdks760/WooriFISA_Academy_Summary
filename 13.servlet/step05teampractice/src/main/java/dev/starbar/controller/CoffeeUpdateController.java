package dev.starbar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;

@WebServlet("/coffees/update")
public class CoffeeUpdateController extends HttpServlet{

	private CoffeeDAO coffeeDAO;
	
	public CoffeeUpdateController() {
		this.coffeeDAO = new CoffeeDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String coffeeId = req.getParameter("coffeeId");
		int id = Integer.parseInt(coffeeId);
		String name = req.getParameter("coffeeName");
		String size = req.getParameter("coffeeSize");
		String coffeePrice = req.getParameter("coffeePrice");
		int price = Integer.parseInt(coffeePrice);
		
		boolean result = coffeeDAO.update(id, name, size, price);
		
		if (result) {
			resp.sendRedirect(req.getContextPath() + "/home.html");
		} else {
			out.print("수정 실패");
		}
		out.close();
	}
	
}