package dev.pattern.singleton.basic;

public class Employee {
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}

	public void usePrinter() {
		CompanyPrinter printer = CompanyPrinter.getPrinter();
		printer.print(name + "가 프린터 " + printer + "를 사용함");
	}
}
