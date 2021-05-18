package com.hcl.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.hcl.demo.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public void deleteByEmployeeId(long Id);

	public List<Employee> getAllemployees();

	public Employee findById(long employeeId);

	public List<Employee> findBybirthDate(LocalDate birthDate);

	public List<Employee> findByLastName(String lastName);

	public List<Employee> findBygender(String gender);

	public List<Employee> findByFirstName(String firstName);

	public List<Employee> findEmployees(String lastName, String birthdate, String gender);
}
