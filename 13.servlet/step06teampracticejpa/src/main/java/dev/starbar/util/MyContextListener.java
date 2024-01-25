package dev.starbar.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyContextListener implements ServletContextListener {
	private static final Logger LOGGER = LogManager.getLogger(MyContextListener.class);
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/";
	final String DATABASE_NAME = "testdb";
	final String USER = "root";
	final String PASSWORD = "1234";
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.info("listener initialized");
		try {
			// MyConnectionPool 사용하기 위해 드라이버 로드
//			Class.forName(DRIVER);
			
//			MyConnectionPool.create(URL + DATABASE_NAME, USER, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.info("listener destoryed");
	}
}