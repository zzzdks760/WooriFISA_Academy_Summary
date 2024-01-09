package dev.syntax.step02;

import dev.syntax.employee.Employee;
import dev.syntax.employee.Skill;

public class SkillFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		
		return employee.getSkills().contains(Skill.JAVA);
	}

}
