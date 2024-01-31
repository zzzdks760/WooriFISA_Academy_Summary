package dev.mvc.steo03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * 기존의 Servlet은 하나의 요청에 대해서 처리를 수행했음
 * GET 요청이면 doGet()
 * POST 요청이면 doPost()
 * 
 * 만약 GET 요청이 2개 이상일 경우에는 별도의 조건식 작성을 통해 구현해야함
 * 
 * 
 * 데이터 삽입 처리의 경우에는 MouseIsertController
 * 데이터 조회 처리의 경우 MouseListController
 * 와 같이 각각의 처리 하나당 하나의 서블릿을 구현했었음
 */
@Controller
@RequestMapping("/mouse-api/mice")
public class MouseController {
	
//	 모든 Mouse 정보 조회 처리용 핸들러 메서드
	public ModelAndView getMice() {
		
	}
	
//	Mouse 등록 처리용 핸들러 메서드
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView addMouse(HttpServletRequest request) {
		
	}
}


