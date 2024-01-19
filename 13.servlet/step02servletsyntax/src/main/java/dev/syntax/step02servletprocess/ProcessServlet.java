package dev.syntax.step02servletprocess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성자
	// 사용자 요청 시 인스턴스 생성됨(브라우저를 새로고침해도 인스턴스가 재생성되지 않음)
	// 주석으로 코드 수정하여 다시 컨텍스트가 로딩되서 출력되는 건 제외
	public ProcessServlet() {
		System.out.println("ProcessServlet() called");
	}

	// 일반 URL 경로(GET요청)로 요청 시 doGet() 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// 표준 HTTP request를 public service()로부터 전달받아서 doXxx()호출
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("protected service() called");
		super.service(req, resp);
	}

	// 클라이언트의 외부 request를 protected service()에게 전달
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("public service() called");
		super.service(req, res);
	}

}
