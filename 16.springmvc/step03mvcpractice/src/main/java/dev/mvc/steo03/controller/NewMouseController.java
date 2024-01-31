package dev.mvc.steo03.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/new-mouse-api/mice") // Mouse와 관련된 처리에 대한 Root 경로 지정
// localhost:8080/step03/mouse-api/mice/ 로 시작하는 모든 요청을 MouseController에서 처리
public class NewMouseController {

	// TapeReader와 Tape와 같은 형태 - MouseController는 MouseService에 의존하고 있음
	private final MouseService mouseService;

	public NewMouseController(MouseService mouseService) {
		System.out.println("MouseController(MouseService mouseService) called");
		this.mouseService = mouseService;
	}

	@GetMapping
	public String getMice(Model model) {
		
		// 전체 조회 요청 로직 처리는 MouseService가 담당
		List<Mouse> mice = mouseService.findAll();
		
		model.addAttribute("mice", mice);
		
		return "mouseList";
	}
	
	@GetMapping("/register")
	public String getMouseRegisterForm() {
		return "mouseRegisterForm";
	}

	@PostMapping("/add")
	public String addMouse(@RequestParam("name") String name, @RequestParam("country")String country, @RequestParam("address")String address) {
		
		Mouse mice = new Mouse(name, country, address);
		mouseService.add(mice);
		
		return "redirect:/mouse-api/mice";
	}
}
