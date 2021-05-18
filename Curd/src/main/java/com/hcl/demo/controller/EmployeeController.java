package com.hcl.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.Employee;
import com.hcl.demo.entity.Salaries;
import com.hcl.demo.entity.Titles;
import com.hcl.demo.exception.EmployeeNotFoundException;
import com.hcl.demo.service.DepartmentService;
import com.hcl.demo.service.EmployeeService;
import com.hcl.demo.util.EmployeeRequestUtil;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/GetAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emmployess = employeeService.getAllemployees();
		return ResponseEntity.ok().body(emmployess);
	}

	@PostMapping("/AddEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee newEmployee = EmployeeRequestUtil.getEmployee(employee);
		Employee emp = employeeService.addEmployee(newEmployee);
		return ResponseEntity.ok().body(emp);

	}

	@GetMapping("/FindById")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee != null)
			return ResponseEntity.ok().body(employee);
		else {

			throw new EmployeeNotFoundException("Id" + employeeId);
		}

	}

	@PutMapping("/UpdateById/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId,
			@RequestBody Employee employeeDetails) {
		Employee employee = employeeService.findById(employeeId);

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setHireDate(employeeDetails.getHireDate());
		employee = employeeService.updateEmployee(employee);
		return ResponseEntity.ok().body(employee);

	}

	@DeleteMapping("/DeleteById/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") long employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee.getEmp_no() == employeeId)
			employeeService.deleteByEmployeeId(employeeId);
		return ResponseEntity.ok("Sucessfully Deleted");

	}

	@GetMapping("/GetByBirthDate/get/{birthdate}")
	public ResponseEntity<List<Employee>> findByBirthDate(@PathVariable(value = "birhtdate") LocalDate birthDate) {
		List<Employee> employee = employeeService.findBybirthDate(birthDate);
		return ResponseEntity.ok().body(employee);
	}

	@GetMapping("/GetByLastName/{lastName}")
	public ResponseEntity<List<Employee>> findByLastName(@RequestParam(value = "lastName") String lastName) {
		List<Employee> employee = employeeService.findByLastName(lastName);
		return ResponseEntity.ok().body(employee);

	}

	@GetMapping("/GetByGender/{gender}")
	public ResponseEntity<List<Employee>> findBygender(@PathVariable(value = "gender") String gender) {
		List<Employee> employee = employeeService.findBygender(gender);
		return ResponseEntity.ok().body(employee);
	}

	@GetMapping("/GetByFirstName/{firstName}")
	public ResponseEntity<List<Employee>> findByFirstName(@PathVariable(value = "firstName") String firstName) {
		List<Employee> employee = employeeService.findByFirstName(firstName);
		return ResponseEntity.ok().body(employee);

	}

	@GetMapping("FindEmployees/{lastName}/{birthdate}/{gender}")
	public ResponseEntity<List<Employee>> findEmployee(@RequestParam String lastName, @RequestParam String birthdate,
			@RequestParam String gender) {
		List<Employee> employeeList = employeeService.findEmployees(lastName, birthdate, gender);
		return ResponseEntity.ok().body(employeeList);
	}

}
