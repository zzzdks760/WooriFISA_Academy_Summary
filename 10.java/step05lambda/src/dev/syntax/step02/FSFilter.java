package dev.syntax.step02;

import dev.syntax.employee.Employee;
import dev.syntax.employee.Unit;

public class FSFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		if (employee.getUnit() == Unit.FS) {
			return true;
		}
		return false;
	}

}
