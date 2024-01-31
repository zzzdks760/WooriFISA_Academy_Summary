package dev.mvc.step02.phase01processrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/phase01/first-controller")
// firstController를 localhost:8080/step02/phase01/first-controller 경로로 지정되어 동작하도록 작성 후 스프링 빈으로 등록
public class FirstController implements Controller{

	// slf4j
	private static final Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("called()");
		
		return null;
	}
	
}
