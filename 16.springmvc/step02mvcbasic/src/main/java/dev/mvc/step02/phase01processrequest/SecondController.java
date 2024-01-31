package dev.mvc.step02.phase01processrequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecondController {

	// slf4j
	private static final Logger logger = LoggerFactory.getLogger(SecondController.class);
	
	@RequestMapping(value = "/phase01/second-controller", method = RequestMethod.GET)
	public void handleRequest() {
		logger.info("second controller called()");
		
	}
	
}
