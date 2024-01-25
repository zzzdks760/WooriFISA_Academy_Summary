package dev.starbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

// http://localhost:8080/step04mvc2practice/coffees로 요청 시 동작할 서블릿

public class CoffeeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		CoffeeDAO coffeeDAO = new CoffeeDAO();
		List<Coffee> coffees = coffeeDAO.findAll();
		
		// 여러 개의 커피 데이터를 .jsp 페이지로 전달
		final String url = "/WEB-INF/coffeeList.jsp";
		
		// 1. RequestDispatcher를 통해 jsp 페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		// coffeeList.jsp에게 "list"라는 이름의 key값으로 coffees 데이터를 전달 
		request.setAttribute("list", coffees);
		
		dispatcher.forward(request, resp); // 실제 이동 진행시켜
	}

}











