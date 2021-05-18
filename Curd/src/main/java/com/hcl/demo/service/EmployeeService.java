package com.hcl.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.hcl.demo.dto.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public void deleteByEmployeeId(long Id);

	public List<Employee> getAllemployees();

	public Employee findById(long employeeId);

	public Employee findBybirthDate(LocalDate birthDate);

	public Employee findByLastName(String lastName);

	public Employee findBygender(String gender);

	public Employee findByFirstName(String firstName);

	public List<Employee> findEmployees(String lastName, String birthdate, String gender);
}
