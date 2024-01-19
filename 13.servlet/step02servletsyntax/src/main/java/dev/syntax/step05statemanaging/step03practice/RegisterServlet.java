package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice-register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String reqName = req.getParameter("id");
		String reqPassword = req.getParameter("password");
		
		Connection connection = DBUtil.getConnection();
		
		String sql = "INSERT INTO user(name, password) VALUES(?, ?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, reqName);
			statement.setString(2, reqPassword);
			
			int update = statement.executeUpdate();
			
			if (update > 0) {
				res.sendRedirect("index.html");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
