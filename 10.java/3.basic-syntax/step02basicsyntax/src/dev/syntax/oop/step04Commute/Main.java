package dev.syntax.oop.step04Commute;

public class Main {

	public static void main(String[] args) {
		//학생 생성
		Student student = new Student("영수", 10000);
		Student student2 = new Student("영철", 5000);
		Student student3 = new Student("영숙", 2000);
 		//대중교통 생성
		Transport busTransport = new Transport();
		Transport subwayTransport = new Transport();
		Bus bus = new Bus("730", busTransport);
		Subway subway = new Subway("2호선", subwayTransport);
		//대중교통 탑승
		bus.boardBus(student);
		bus.boardBus(student2);
		subway.boardSubway(student3);
		//학생정보 조회, 대중교통 조회
		student.studentInfo();
		student2.studentInfo();
		student3.studentInfo();
	}

}
