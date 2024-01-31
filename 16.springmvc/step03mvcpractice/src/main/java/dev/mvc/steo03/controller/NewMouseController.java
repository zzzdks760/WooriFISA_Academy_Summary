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
 * ������ Servlet�� �ϳ��� ��û�� ���ؼ� ó���� ��������
 * GET ��û�̸� doGet()
 * POST ��û�̸� doPost()
 * 
 * ���� GET ��û�� 2�� �̻��� ��쿡�� ������ ���ǽ� �ۼ��� ���� �����ؾ���
 * 
 * 
 * ������ ���� ó���� ��쿡�� MouseIsertController
 * ������ ��ȸ ó���� ��� MouseListController
 * �� ���� ������ ó�� �ϳ��� �ϳ��� ������ �����߾���
 */
@Controller
@RequestMapping("/new-mouse-api/mice") // Mouse�� ���õ� ó���� ���� Root ��� ����
// localhost:8080/step03/mouse-api/mice/ �� �����ϴ� ��� ��û�� MouseController���� ó��
public class NewMouseController {

	// TapeReader�� Tape�� ���� ���� - MouseController�� MouseService�� �����ϰ� ����
	private final MouseService mouseService;

	public NewMouseController(MouseService mouseService) {
		System.out.println("MouseController(MouseService mouseService) called");
		this.mouseService = mouseService;
	}

	@GetMapping
	public String getMice(Model model) {
		
		// ��ü ��ȸ ��û ���� ó���� MouseService�� ���
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
