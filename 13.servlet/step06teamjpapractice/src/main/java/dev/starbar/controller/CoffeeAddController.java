package dev.starbar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;

@WebServlet("/coffees/add")
public class CoffeeAddController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		CoffeeDAO coffeeDAO = new CoffeeDAO();
		
		String coffeePrice = req.getParameter("coffeePrice");
		int price = Integer.parseInt(coffeePrice);
		
		boolean result = coffeeDAO.save(req.getParameter("coffeeName"), req.getParameter("coffeeSize"), price);
		
		if (result) {
			resp.sendRedirect(req.getContextPath() + "/home.html");
		} else {
			out.print("올바른 값을 입력하세요");
		}
		out.close();
	}
	
}
