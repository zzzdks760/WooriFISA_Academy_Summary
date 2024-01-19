package dev.pattern.singleton.basic;

/*
 * 회사에 프린터기(CompanyPrinter)가 있는데
 * 직원(Employee)이 프린터기를 공유해서 사용
 * 프린터기는 회사 내에 1대 밖에 없음(인스턴스가 1개)
 * 
 */
public class Company {
	
	private static final int EMPLOYEES = 5;

	public static void main(String[] args) {
		Employee[] employees = new Employee[EMPLOYEES];
		
		for (int i = 0; i < EMPLOYEES; i++) {
			employees[i] = new Employee("user-" + i);
			employees[i].usePrinter();
		}
//		new CompanyPrinter();
	}

}
