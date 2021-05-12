package com.hcl.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.EmployeeRepository;
import com.hcl.demo.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllemployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteByEmployeeId(long Id) {
		employeeRepository.deleteById(Id);
	}

	@Override
	public Employee findById(long employeeId) {
		Optional<Employee> employeedetails = employeeRepository.findById(employeeId);
		if (employeedetails.isPresent()) {
			return employeedetails.get();
		}
		return null;
	}

	@Override
	public Employee findBybirthDate(LocalDate birthDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findBygender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
}
