package com.example.codeclan.employeeservice;

import models.Department;
import models.Employee;
import models.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repositories.DepartmentRepository;
import repositories.EmployeeRepository;
import repositories.ProjectRepository;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void canCreateAndSaveEmployeeThatHasDepartmentAndProject(){
		Project project = new Project("Dynamite", 30);
		projectRepository.save(project);
		Department department = new Department("Development");
		departmentRepository.save(department);
		Employee employee = new Employee("John Wayne", 37, "1234567", "jwayne@codeclan.com" , department);
		employeeRepository.save(employee);
		employee.addProject(project);
		employeeRepository.save(employee);
	}
}

