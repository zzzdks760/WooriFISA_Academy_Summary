package dev.exam.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.exam.model.Reservation;

@WebServlet("/tennis/reserve")
public class CourtReserveServlet extends HttpServlet {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// form 입력 값 추출
		String reservedTimeString = request.getParameter("datetime");
		LocalDateTime reservedTime = LocalDateTime.parse(reservedTimeString, formatter);

		int courtNumber = Integer.parseInt(request.getParameter("court"));
		String centerName = request.getParameter("center");

		Reservation reservation = new Reservation(centerName, courtNumber, reservedTime);

		// 예매 처리가 수행되었다고 가정
		// ex. reservationService.save(reservation);

		request.setAttribute("reservation", reservation);

		final String path = "/WEB-INF/success.jsp";
		final String path2 = "/WEB-INF/unauthorized.jsp";
		String allowedReferer = "http://localhost:8080/fairtennis/courtList.jsp";
		String referer = request.getHeader("Referer");
		System.out.println("referer: " + referer);
		
		if (request.getHeader("Referer") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path2);
			dispatcher.forward(request, response);
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		
	}

}
