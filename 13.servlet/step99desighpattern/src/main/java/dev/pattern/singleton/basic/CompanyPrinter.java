package dev.pattern.singleton.basic;

// 회사에 하나뿐인 프린터기, 1명씩 번갈아가면서 써야함
public class CompanyPrinter {
	
	// 그 외 나머지 완성
	private CompanyPrinter() {}
	
	private static CompanyPrinter printer = new CompanyPrinter();
	
	/**
	 * 프린터 사용
	 */
	public void print(String operation) {
		System.out.println(operation);
	}
	
	/**
	 * 프린터를 취득할 수 있는 메서드
	 */
	static CompanyPrinter getPrinter() {
		return printer;
	}
	
	/**
	 * 프린터가 고유한지 확인하는 일련번호 조회 메서드
	 */
	public String toString() {
		return "Serial No." + Integer.toHexString(hashCode());
	}
	
}