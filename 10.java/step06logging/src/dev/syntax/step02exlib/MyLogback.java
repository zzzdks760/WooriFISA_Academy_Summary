package dev.syntax.step02exlib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogback {

    private static final Logger logger = LoggerFactory.getLogger(MyLogback.class);

    public static void main(String[] args) {
        logger.debug("DEBUG 되냐?");
        logger.error("ERROR 메시지");
        logger.info("INFO 메시지");
    }
}