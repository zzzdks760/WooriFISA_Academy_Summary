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
@RequestMapping("/mouse-api/mice") // Mouse�� ���õ� ó���� ���� Root ��� ����
// localhost:8080/step03/mouse-api/mice/ �� �����ϴ� ��� ��û�� MouseController���� ó��
public class MouseController {

	// TapeReader�� Tape�� ���� ���� - MouseController�� MouseService�� �����ϰ� ����
	private final MouseService mouseService;

	public MouseController(MouseService mouseService) {
		System.out.println("MouseController(MouseService mouseService) called");
		this.mouseService = mouseService;
	}

	// ��� Mouse ���� ��ȸ ó���� �ڵ鷯 �޼���
	@RequestMapping // localhost:8080/step03/mouse-api/mice/�� ��� ����
	// @RequestMapping�� ����� ��� GET���� ����
	public ModelAndView getMice() {
		
		// ��ü ��ȸ ��û ���� ó���� MouseService�� ���
		List<Mouse> mice = mouseService.findAll();
		
		// ModelAndView ��ü ����
		ModelAndView mnv = new ModelAndView();
		
		// ModelAndView ��ü�� model �������� mice�� �߰�
		mnv.addObject("mice", mice); // request.setAttribute("mice", mice); �� ����� ���
		
		// ModelAndView ��ü�� view ������ �̸��� mouseList ���� 
		// (mouseList.jsp�� �������� �ϱ� ������)
		mnv.setViewName("mouseList"); // WEB-INF/views/
		
		return mnv;
	}
	
	// ������ ���� - ���� Mouse ��� ���� ��Ʈ�ѷ��� ���ļ� �ؾ��� ���
	/*
	 * GET: localhost:8080/step03/mouse-api/mice/register�� ��û�� ��� ������ �ڵ鷯
	 * mouseRegisterForm.jsp�� �����ϵ���   
	 */
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView getMouseRegisterForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mouseRegisterForm");
		return mv;
	}

	// ���� Mouse ��� ó���� �ڵ鷯 �޼���
	@RequestMapping(path ="/add", method = RequestMethod.POST)
	// POST: localhost:8080/step03/mouse-api/mice/add�� ��û�� ��� ����
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
