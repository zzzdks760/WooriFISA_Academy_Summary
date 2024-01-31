package dev.mvc.step02.phase02revolvingview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * phase01processrequest.SecondController.java에서 작성한 방식으로 view에 대한 처리 수행하는 코드
 * 
 */
@Controller
public class SecondResolvingViewController {

	private static final Logger logger = LoggerFactory.getLogger(SecondResolvingViewController.class);
	
	@RequestMapping(value = "/phase02/second-controller", method = RequestMethod.GET)
	public ModelAndView handleRquest() {
		
		logger.info("second-controller called()");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", "sungmin");
		mv.addObject("email", "naver");
		
		mv.setViewName("test");
		
		return mv;
	}
}
