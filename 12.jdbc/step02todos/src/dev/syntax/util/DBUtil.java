package dev.syntax.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * DB와 관련된 공통 처리 코드들을 별도의 유틸 클래스로 작성
 */
public class DBUtil {
	
	/*
		java.util 패키지에서 제공하는 Properties 활용
		
		resources 폴더에 jdbc.properties라는 파일을 생성 후
		해당 파일 내에 DB 연결과 관련된 설정 정보를 작성해두고
		
		DBUtil.java가 그 파일을 읽어서 DB 커넥션을 수행할 수 있도록 작성
	*/
	
	public static Connection getConnection() {
		// 코드 작성 후 App.java에서 호출 가능하도록
		Properties prop = new Properties();
		
		try {
			FileInputStream fs = new FileInputStream("resources/jdbc.properties");
			
			prop.load(fs);
			
			prop.list(System.out);
			
			final String DB_URL = prop.getProperty("url");
			final String DATABASE_NAME = prop.getProperty("database");
			final String USER = prop.getProperty("username");
			final String PASSWORD = prop.getProperty("password");
			
			return DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
