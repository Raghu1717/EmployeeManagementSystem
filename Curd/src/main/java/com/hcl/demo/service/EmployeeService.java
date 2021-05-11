package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.dto.Employee;


public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(long id);
	
	public Employee getEmployee(long id);
	
	public List<Employee> getAllemployees();

}
