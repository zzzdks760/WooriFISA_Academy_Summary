package dev.syntax.step07filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/output1")
public class OutputServlet1 extends HttpServlet {

	// filterInput1.html에서 폼으로 입력받은 값을 화면에 출력하는 코드 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.print(req.getParameter("name"));
		out.close();
	}


}