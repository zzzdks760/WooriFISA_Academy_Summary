package dev.mvc.step02.phase02revolvingview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * phase01processrequest.FirstController.java에서 작성한 방식으로 view에 대한 처리 수행하는 코드
 */
@Component(value = "/phase02/second-resolving-controller")
public class FirstResolvingViewController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(FirstResolvingViewController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("-- phase02/second-resolving-controller() called");
		
		// 추상 메서드가 요구하는 반환 타입인 ModelAndView 객체로 반환
		/*
		 * View 페이지에 대한 경로
		 * View 페이지에서 사용할 Model 객체
		 * 등을 바인딩하는 용도의 클래스
		 */
		ModelAndView mnv = new ModelAndView();
		
		// View 페이지의 경로 지정
		mnv.setViewName("home"); // view 파일 이름이 home이라는 의미
		
		// 현재 이 코드에서는 별도의 모델 객체가 없는 경우라고 가정
		
		return mnv; // mnv 객체 반환
	}

}
