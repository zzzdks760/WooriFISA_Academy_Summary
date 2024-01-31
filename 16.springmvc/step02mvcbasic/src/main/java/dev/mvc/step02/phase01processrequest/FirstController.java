package dev.mvc.step02.phase01processrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/phase01/first-controller")
// firstController�� localhost:8080/step02/phase01/first-controller ��η� �����Ǿ� �����ϵ��� �ۼ� �� ������ ������ ���
public class FirstController implements Controller{

	// slf4j
	private static final Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("called()");
		
		return null;
	}
	
}
