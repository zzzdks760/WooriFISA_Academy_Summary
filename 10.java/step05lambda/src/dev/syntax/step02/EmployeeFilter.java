package dev.syntax.step02;

import dev.syntax.employee.Employee;

/**
 * EmployeeFilter 인터페이스는 filterEmployee()를 추상메서드로 가지고 있음
 */

public interface EmployeeFilter {
	boolean filterEmployee(Employee employee);
}
