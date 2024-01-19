package dev.syntax.step05statemanaging.step03practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/practice-login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String reqName = req.getParameter("id");
		String reqPassword = req.getParameter("password");
		
		Connection connection = DBUtil.getConnection();
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("userId")!= null) {
			out.println("이미 로그인되었습니다.");
			return;
		}
		
		session.setMaxInactiveInterval(60);
		
		String sql = "Select * from user where name = ? AND password = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, reqName);
			statement.setString(2, reqPassword);
			
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					int userId = rs.getInt("user_id");
					session.setAttribute("userId", userId);
					res.sendRedirect("index.html");
				} else {
					out.println("로그인 실패");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
