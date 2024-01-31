package dev.mouse.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mouse-api/*")
public class FrontController extends HttpServlet{
	private Map<String, ControllerV1> map = new HashMap<>();
	
	public FrontController () {
		map.put("/mice", new MouseListController());
		map.put("/mice/add", new MouseInsertController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String path = req.getPathInfo();
		ControllerV1 controllerV1 = map.get(path);
		if (controllerV1 == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		controllerV1.process(req, resp);
	}
	
	
}
