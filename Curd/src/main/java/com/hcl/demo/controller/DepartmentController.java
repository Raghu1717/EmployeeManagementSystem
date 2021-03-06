package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.Departments;
import com.hcl.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/Add Department")
	public ResponseEntity<Departments> createDepartments(@RequestBody Departments department) {
		department = departmentService.addDepartment(department);
		return ResponseEntity.ok().body(department);

	}

	@DeleteMapping("/DepartmentDeletedById/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable(value = "id") int id) {
		Departments department = departmentService.getDepartment(id);
		if (department != null && department.getDepartNo() == id) {
			departmentService.deleteDepartment(id);
			return ResponseEntity.ok("Sucessfully Deleted");
		} else {
			return ResponseEntity.ok("Department Not Found");
		}
	}

	@GetMapping("/DepartmentGetByID/{id}")
	public ResponseEntity<Departments> getDepartmentById(@PathVariable(value = "id") int id) {
		Departments department = departmentService.getDepartment(id);
		if (department == null) {
			return ResponseEntity.ok().body(new Departments());
		}
		return ResponseEntity.ok().body(department);

	}

	@PutMapping("/DepartmentUpdate/{department}")
	public ResponseEntity<Departments> updateDepartment(@RequestBody Departments department) {
		department = departmentService.updateDepartment(department);
		return ResponseEntity.ok().body(department);

	}

	@GetMapping("/GetAllDepartments")
	public ResponseEntity<List<Departments>> getAllDepartments() {
		return ResponseEntity.ok().body(departmentService.getAllDepartments());

	}

}
