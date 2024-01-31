package dev.mvc.steo03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/mouse-api/mice")
public class MouseController {
	
//	 ��� Mouse ���� ��ȸ ó���� �ڵ鷯 �޼���
	public ModelAndView getMice() {
		
	}
	
//	Mouse ��� ó���� �ڵ鷯 �޼���
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView addMouse(HttpServletRequest request) {
		
	}
}


