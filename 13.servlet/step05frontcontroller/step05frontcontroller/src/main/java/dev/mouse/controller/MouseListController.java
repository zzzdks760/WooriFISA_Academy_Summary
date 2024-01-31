package dev.mouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.model.Mouse;
import dev.mouse.service.MouseService;

@WebServlet("/mice")
public class MouseListController extends HttpServlet {

	private MouseService mouseService = new MouseService();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Mouse> mice = mouseService.findAll();
		
		request.setAttribute("mice", mice);
		
		String path = "/WEB-INF/mouseList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
