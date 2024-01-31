package dev.mouse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.model.Mouse;
import dev.mouse.service.MouseService;

public class MouseInsertController extends HttpServlet implements ControllerV1{
	
	private MouseService mouseService = new MouseService();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseService.add(newMouse);
		
		String path = request.getContextPath() + "/index.html";
		response.sendRedirect(path);
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response); 요청을 다른 url에 넘기는것
	}

}
