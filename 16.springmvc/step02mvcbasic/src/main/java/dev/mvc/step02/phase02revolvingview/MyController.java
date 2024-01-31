package dev.mvc.step02.phase02revolvingview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.mvc.step02.phase01processrequest.SecondController;

@Controller
public class MyController {

	// slf4j
	private static final Logger logger = LoggerFactory.getLogger(SecondController.class);
	
	@RequestMapping(value = "/v1/find", method = RequestMethod.GET)
	public void find() {
		logger.info("find 메서드 호출");
	}
}
