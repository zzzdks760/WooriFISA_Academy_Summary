package dev.syntax.step04;

import java.util.ArrayList;
import java.util.List;

import dev.syntax.employee.Designation;
import dev.syntax.employee.Employee;
import dev.syntax.employee.Skill;
import dev.syntax.employee.Unit;

public class Step04UsingLambdaExpression {

	private static final List<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {
		initialize();
		
		// 금융팀(FS)에 속한 모든 사원 목록 조회
        System.out.println("== 금융팀 사원 목록 ==");
//        EmployeeFilter fsFilter = new FSFilter();
        //EmployeeFilter를 구현한 구현 클래스 FSFilter 작성
//        EmployeeFilter fsFilter = new EmployeeFilter() {
//			
//			@Override
//			public boolean filterEmployee(Employee employee) {
//				// TODO Auto-generated method stub
//				return employee.getUnit() == Unit.FS;
//			}
//		};
		
		EmployeeFilter fsFilter = employee -> employee.getUnit() == Unit.FS;
		System.out.println(getAllEmployeesFilteredBy(fsFilter));
		
		EmployeeFilter msFilter = employee -> employee.getUnit() == Unit.MS;
		System.out.println(getAllEmployeesFilteredBy(msFilter));
		
		EmployeeFilter skillFilter = employee -> employee.getSkills().contains(Skill.JAVA);
		System.out.println(getAllEmployeesFilteredBy(skillFilter));
        
		EmployeeFilter experienceFilter = employee -> employee.getExperience() >= 10;
		System.out.println(getAllEmployeesFilteredBy(experienceFilter));

		
	}
	
	private static List<Employee> getAllEmployeesFilteredBy(EmployeeFilter filter) {
		List<Employee> filterdEmplyees = new ArrayList<>();
		for (Employee employee : employees) {
			if (filter.filterEmployee(employee)) {// 비교로직을 제외하고는 모두 중복 로직
				filterdEmplyees.add(employee);
			}
		}
		return filterdEmplyees;
	}
	
	// 초기 더미 데이터 세팅
	public static void initialize() {
        List<Skill> dev1Skills = new ArrayList<>();
        dev1Skills.add(Skill.JAVA);
        dev1Skills.add(Skill.JPA);


        employees.add(new Employee("이나무", 8, Designation.DEVELOPER, Unit.FS, dev1Skills));


        List<Skill> dev2Skills = new ArrayList<>();
        dev2Skills.add(Skill.MICROSOFT);
        employees.add(new Employee("유아리", 5, Designation.DEVELOPER, Unit.FS, dev2Skills));


        List<Skill> dev3Skills = new ArrayList<>();
        dev3Skills.add(Skill.PYTHON);
        employees.add(new Employee("하버들", 7, Designation.DEVELOPER, Unit.FS, dev3Skills));


        List<Skill> dev4Skills = new ArrayList<>();
        dev4Skills.add(Skill.ANGULARJS);
        dev4Skills.add(Skill.JAVASCRIPT);
        employees.add(new Employee("권나길", 3, Designation.DEVELOPER, Unit.MS, dev4Skills));


        List<Skill> dev5Skills = new ArrayList<>();
        dev5Skills.add(Skill.ANGULARJS);
        dev5Skills.add(Skill.JAVA);
        employees.add(new Employee("오다운", 3, Designation.DEVELOPER, Unit.FS, dev5Skills));


        List<Skill> managerSkills = new ArrayList<>();
        managerSkills.add(Skill.PMP);
        employees.add(new Employee("윤믿음", 15, Designation.MANAGER, Unit.FS, managerSkills));


        List<Skill> architectSkills = new ArrayList<>();
        architectSkills.add(Skill.DESIGN);
        employees.add(new Employee("강한울", 13, Designation.ARCHITECT, Unit.FS, architectSkills));
    }


}
