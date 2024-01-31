package dev.mouse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.model.Mouse;
import dev.mouse.service.MouseService;

@WebServlet("/mice/add")
public class MouseInsertController extends HttpServlet {
	
	private MouseService mouseService = new MouseService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mouseInsertController");
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseService.add(newMouse);
		
		String path = "/mice";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
