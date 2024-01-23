package dev.starbar.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/*
 * HikariCP 라이브러리를 편하게 사용하기 위한 래퍼(Wrapper) 클래스a
 */
public class HikariCPDataSource {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;
	static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	static {
		// 필수 설정 파라미터(url, username, password), classname은 이전 버전 제외하고 생략 가능
		config.setJdbcUrl("jdbc:mysql://localhost:3306/testdb"); // DB이름은 URL 뒷 부분에 추가하여 기술
		config.setUsername("root");
		config.setPassword("1234");
		config.setConnectionTimeout(60000);
		// HikariCP Official, https://github.com/brettwooldridge/HikariCP
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 상세 프로퍼티 설명(https://github.com/brettwooldridge/HikariCP#frequently-used)
		ds = new HikariDataSource(config);

	}

	public static Connection getConnection() {
	
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private HikariCPDataSource() {
	}
}
