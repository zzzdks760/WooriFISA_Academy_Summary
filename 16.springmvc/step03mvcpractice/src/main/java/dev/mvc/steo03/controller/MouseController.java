package dev.mvc.steo03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.steo03.model.Mouse;
import dev.mvc.steo03.service.MouseService;

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
@RequestMapping("/mouse-api/mice") // Mouse와 관련된 처리에 대한 Root 경로 지정
// localhost:8080/step03/mouse-api/mice/ 로 시작하는 모든 요청을 MouseController에서 처리
public class MouseController {

	// TapeReader와 Tape와 같은 형태 - MouseController는 MouseService에 의존하고 있음
	private final MouseService mouseService;

	public MouseController(MouseService mouseService) {
		System.out.println("MouseController(MouseService mouseService) called");
		this.mouseService = mouseService;
	}

	// 모든 Mouse 정보 조회 처리용 핸들러 메서드
	@RequestMapping // localhost:8080/step03/mouse-api/mice/일 경우 동작
	// @RequestMapping만 사용할 경우 GET으로 동작
	public ModelAndView getMice() {
		
		// 전체 조회 요청 로직 처리는 MouseService가 담당
		List<Mouse> mice = mouseService.findAll();
		
		// ModelAndView 객체 생성
		ModelAndView mnv = new ModelAndView();
		
		// ModelAndView 객체에 model 데이터인 mice를 추가
		mnv.addObject("mice", mice); // request.setAttribute("mice", mice); 와 비슷한 방식
		
		// ModelAndView 객체에 view 파일의 이름인 mouseList 지정 
		// (mouseList.jsp로 보내려고 하기 때문에)
		mnv.setViewName("mouseList"); // WEB-INF/views/
		
		return mnv;
	}
	
	// 연습용 예시 - 만약 Mouse 등록 폼을 컨트롤러를 거쳐서 해야할 경우
	/*
	 * GET: localhost:8080/step03/mouse-api/mice/register로 요청할 경우 동작할 핸들러
	 * mouseRegisterForm.jsp로 응답하도록   
	 */
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView getMouseRegisterForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mouseRegisterForm");
		return mv;
	}

	// 실제 Mouse 등록 처리용 핸들러 메서드
	@RequestMapping(path ="/add", method = RequestMethod.POST)
	// POST: localhost:8080/step03/mouse-api/mice/add로 요청할 경우 동작
	public ModelAndView addMouse(HttpServletRequest request) {
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		ModelAndView mv = new ModelAndView();

		
		Mouse mice = new Mouse(name, country, address);
		mouseService.add(mice);
		
		mv.setViewName("redirect:/mouse-api/mice");
		
		return mv;
	}
}
