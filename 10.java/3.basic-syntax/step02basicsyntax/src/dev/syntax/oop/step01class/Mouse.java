package dev.syntax.oop.step01class;

public class Mouse {
	// 필드
	String name;
	String address;
	final String country = "KOREA";
	int age;
	
	// 메서드
	void sing() {
		System.out.println(name + "찍찍");
	}
	
	public Mouse() {
		System.out.println("기본 생성자 Mouse 호출");
	}
	
	public Mouse(String name) {
		this.name = name;
	}
	
	public Mouse(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", address=" + address + ", country=" + country + ", age=" + age + "]";
	}
	
}
