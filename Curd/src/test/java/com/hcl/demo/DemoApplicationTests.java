package com.hcl.demo;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hcl.demo.dao.EmployeeRepository;
import com.hcl.demo.dto.DepartmentManager;
import com.hcl.demo.dto.Departments;
import com.hcl.demo.dto.Employee;
import com.hcl.demo.dto.Salaries;
import com.hcl.demo.dto.Titles;
import com.hcl.demo.service.EmployeeService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmployeeService service;
	@MockBean
	private EmployeeRepository repository;

	@Test
	@DisplayName("Test findById Success")
	void testFindById() {
		// Setup our mock repository
		LocalDate date = LocalDate.now();
		Employee employee = new Employee();
		employee.setEmp_no(1);
		employee.setBirthDate(date);
		employee.setFirstName("Raghu");
		employee.setLastName("T");
		employee.setHireDate(date);
		Salaries salaries = new Salaries();
		salaries.setEmployee(employee);
		employee.setSalary(salaries);
		salaries.setFromDate(date);
		salaries.setToDate(date);
		List<DepartmentManager> departmentManagers = new ArrayList();
		DepartmentManager department = new DepartmentManager();
		Departments departments = new Departments();
		departments.setDepartNo(1);
		departments.setDepartName("IT");
		department.setEmployee(employee);
		department.setDepartment(departments);
		departmentManagers.add(department);
		Titles title = new Titles();
		title.setEmployee(employee);
		title.setTitle("TeamLead");
		title.setFromDate(date);
		title.setFromDate(date);

		doReturn(Optional.of(employee)).when(repository).findById(1l);
		Employee newemployee = service.findById(1);

		Assertions.assertTrue(newemployee.getEmp_no() == 1, "Widget was not found");
		Assertions.assertSame(newemployee, employee, "The widget returned was not the same as the mock");
	}

}