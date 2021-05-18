package com.hcl.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entity.Employee;
import com.hcl.demo.exception.BadRequestException;
import com.hcl.demo.exception.EmployeeNotFoundException;
import com.hcl.demo.repository.EmployeeRepository;

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
	public List<Employee> findBybirthDate(LocalDate birthDate) {
		if (birthDate != null) {
			employeeRepository.findByBirthDate(birthDate);
		}
		throw new BadRequestException("BirthDate" + birthDate);
	}

	@Override
	public List<Employee> findBygender(String gender) {
		if (gender != null) {
			employeeRepository.findByGender(gender);
		}
		throw new BadRequestException("Gender" + gender);
	}

	@Override
	public List<Employee> findByLastName(String lastName) {
		if (lastName != null) {
			return employeeRepository.findByLastName(lastName);
		}
		throw new BadRequestException("LastName" + lastName);

	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		if (firstName != null) {
			return employeeRepository.findByFirstName(firstName);
		}
		throw new BadRequestException("FirstName" + firstName);
	}

	@Override
	public List<Employee> findEmployees(String lastName, String birthDate, String gender) {
		if (lastName != null && birthDate != null && gender != null) {

			return employeeRepository.findByLastNameAndBirthDateAndGender(lastName, birthDate, gender);

		}

		throw new BadRequestException("LastName" + lastName + "....BirthDate" + birthDate + "...+Gender:" + gender);

	}

}
