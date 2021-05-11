package com.hcl.demo.service;

import java.util.List;

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
		return employee;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllemployees() {
	
		return employeeRepository.findAll();
	}

}
