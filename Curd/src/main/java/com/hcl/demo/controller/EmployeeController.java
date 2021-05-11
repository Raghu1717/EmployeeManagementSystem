package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.Employee;
import com.hcl.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllemployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);

	}

}
