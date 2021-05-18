package com.hcl.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.EmployeeRepository;
import com.hcl.demo.dto.Employee;
import com.hcl.demo.exception.EmployeeNotFoundException;

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
		if (birthDate != null) {
			employeeRepository.findByBirthDate(birthDate);
		}
		throw new EmployeeNotFoundException("BirthDate" + birthDate);
	}

	@Override
	public Employee findBygender(String gender) {
		if (gender != null) {
			employeeRepository.findByGender(gender);
		}
		throw new EmployeeNotFoundException("Gender" + gender);
	}

	@Override
	public Employee findByLastName(String lastName) {
		if (lastName != null) {
			employeeRepository.findByLastName(lastName);
		}
		throw new EmployeeNotFoundException("LastName" + lastName);
	}

	@Override
	public Employee findByFirstName(String firstName) {
		if (firstName != null) {
			employeeRepository.findByFirstName(firstName);
		}
		throw new EmployeeNotFoundException("FirstName" + firstName);
	}

	@Override
	public List<Employee> findEmployees(String lastName, String birthDate, String gender) {
		if (lastName != null && birthDate != null && gender != null) {

			List<Employee> employeelist = employeeRepository.findAll();

		}

		throw new RuntimeException();

	}

}
