package dev.starbar.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConnectionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		MyConnectionPool.create("jdbc:mysql://localhost:3306/testdb", "root", "1234", );
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}

	
}
