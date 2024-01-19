package dev.syntax.step05statemanaging.step02session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if (id.isEmpty() || pwd.isEmpty()) {
			out.print("아이디 및 비밀번호를 입력해주세요");
			return;
		}
		
		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id); // id라는 이름의 키값에 사용자의 id값을 value로 설정
			out.print("로그인 완료");
		} else {
			out.print("이미 로그인 중입니다.");
		}
		
		out.close();
	}

	
}
