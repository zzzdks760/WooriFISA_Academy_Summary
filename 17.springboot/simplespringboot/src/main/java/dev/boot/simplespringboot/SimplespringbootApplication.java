package dev.boot.simplespringboot;


import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class SimplespringbootApplication {

	private static Logger logger = LoggerFactory.getLogger(SimplespringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimplespringbootApplication.class, args);
		logger.debug("디버그 레벨 로그 출력 테스트");

		log.info("로그");
	}

}
