package dev.syntax.step02;

import dev.syntax.employee.Employee;

public class ExperienceFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getExperience() >= 10;
	}

}
