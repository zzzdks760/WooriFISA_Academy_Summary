package dev.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * 커넥션 풀 개념을 간이로 구현한 클래스  
 * 
 * 개발자는 이 클래스를 통해 커넥션 객체를 취득해서 DB 접근 및 처리가 가능해야함
 * 
 * 1. Field Summary - 이 클래스가 가지고 있는 필드 목록
 *
 *	1-1. 미리 생성해둔 커넥션 객체들을 보관할 풀(Pool), 풀장
 *	List<Connection> connectionPool;
 *
 *	1-2. 클라이언트에게 빌려줘서 사용 중인 커넥션 객체들(커넥션 풀에서 꺼내서 사용)
 *	List<Connection> usedConnections;
 *
 *	1-3. 커넥션 객체 생성을 위한 DB 설정 정보(URL, USERNAME, PASSWORD)
 *	String url;
 *	String username;
 *	String password;
 *
 *	1-4. 최대로 생성해둘 커넥션 객체의 개수
 *	int INITIAL_POOL_SIZE;
 * 
 * 
 * 2. Method Summary - 이 클래스가 가지고 있는 메서드 목록
 * 
 * 2-1. 커넥션 객체가 아닌 커넥션 풀 객체 자체를 생성할 메서드 
 * MyConnectionPool create(url, username, password);
 * 
 * 2-2. 커넥션 객체를 취득할 수 있는 커넥션 객체 취득용 메서드 
 * Connection getConnection();
 * 
 * 2-3. DB 입출력에 사용이 다 끝났을 경우 커넥션 객체 반납 처리
 * boolean releaseConnection(Connection connection)
 * 
 */
public class MyConnectionPool {
	
	private String url; // DB 서버 URL
	private String user; // DB 서버에 접근하는 사용자 계정 이름
	private String password; // DB 서버에 접근하는 사용자 계정 비밀번호
	private static List<Connection> connectionPool; // 미리 생성할 커넥션 객체들을 보관할 리스트(커넥션 풀), 풀장 
	private static List<Connection> usedConnections = new ArrayList<>(); // 사용된 커넥션 객체들
	private static int INITIAL_POOL_SIZE = 10; // 최대로 생성할 커넥션 객체 개수

	// 커넥션 풀 생성
	public static MyConnectionPool create(String url, String user, String password) throws SQLException {

		List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
		
		// 최대 사이즈(INITAL_POOL_SIZE) 만큼 커넥션 객체 생성
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			pool.add(createConnection(url, user, password)); // 풀에 커넥션 객체 담기
		}
		return new MyConnectionPool(url, user, password, pool);
	}

	private MyConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		MyConnectionPool.connectionPool = connectionPool;
	}

	// DB 입출력에 사용할 커넥션 객체 가져오기
	public static Connection getConnection() {
		Connection connection = connectionPool.remove(connectionPool.size() - 1);
		usedConnections.add(connection);
		return connection;
	}

	// DB 입출력에 사용이 다 끝난 커넥션 객체 반납하기
	public static boolean releaseConnection(Connection connection) {
		connectionPool.add(connection);
		return usedConnections.remove(connection);
	}

	// 하나의 커넥션 객체 생성 - 팩토리 메서드
	private static Connection createConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// 현재 사용 가능 커넥션 및 사용 중인 커넥션 개수 확인 
	public int getSize() {
		return connectionPool.size() + usedConnections.size();
	}
	
	// 커넥션 풀 종료
	public static void shutdown() throws SQLException {
	    usedConnections.forEach(MyConnectionPool::releaseConnection); // :: 메서드 참조(Method Reference) 문법
	    for (Connection c : connectionPool) {
	        c.close();
	    }
	    connectionPool.clear();
	}
}