package dev.mouse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.dao.MouseDAO;
import dev.mouse.model.Mouse;

/**
 * 화면에서 입력받은 Mouse 데이터를 DB에 등록하는 처리를 수행하는 서블릿
 */

@WebServlet("/mice/add")
public class MouseInsertServlet extends HttpServlet {
	private final MouseDAO mouseDAO;

	public MouseInsertServlet() {
		this.mouseDAO = new MouseDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseDAO.add(newMouse); // DB INSERT 처리 수행
		
		String path = "/mice";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}
}
