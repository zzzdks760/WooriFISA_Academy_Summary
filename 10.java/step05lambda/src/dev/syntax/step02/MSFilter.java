package dev.syntax.step02;

import dev.syntax.employee.Employee;
import dev.syntax.employee.Unit;

public class MSFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getUnit() == Unit.MS;
	}

}
