package dev.mvc.step02.phase02revolvingview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * phase01processrequest.FirstController.java���� �ۼ��� ������� view�� ���� ó�� �����ϴ� �ڵ�
 */
@Component(value = "/phase02/second-resolving-controller")
public class FirstResolvingViewController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(FirstResolvingViewController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("-- phase02/second-resolving-controller() called");
		
		// �߻� �޼��尡 �䱸�ϴ� ��ȯ Ÿ���� ModelAndView ��ü�� ��ȯ
		/*
		 * View �������� ���� ���
		 * View ���������� ����� Model ��ü
		 * ���� ���ε��ϴ� �뵵�� Ŭ����
		 */
		ModelAndView mnv = new ModelAndView();
		
		// View �������� ��� ����
		mnv.setViewName("home"); // view ���� �̸��� home�̶�� �ǹ�
		
		// ���� �� �ڵ忡���� ������ �� ��ü�� ���� ����� ����
		
		return mnv; // mnv ��ü ��ȯ
	}

}
