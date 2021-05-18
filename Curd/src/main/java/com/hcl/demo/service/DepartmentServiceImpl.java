package com.hcl.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.DepartmentRepository;
import com.hcl.demo.dto.Departments;
import com.hcl.demo.dto.Employee;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepostiory;

	@Override
	public Departments addDepartment(Departments department) {
		return departmentRepostiory.save(department);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentRepostiory.deleteById(id);

	}

	@Override
	public Departments getDepartment(int id) {
		Optional<Departments> department = departmentRepostiory.findById(id);
		if (department.isPresent()) {
			department.get();
		}
		return null;
	}

	@Override
	public Departments updateDepartment(Departments department) {
		Optional<Departments> departments = departmentRepostiory.findById(department.getDepartNo());
		if (departments.isPresent()) {
			departments.get().setDepartName(department.getDepartName());
			departmentRepostiory.save(departments.get());

		}

		return null;
	}

	@Override
	public void deleteAllDepartment() {
		departmentRepostiory.deleteAll();

	}

	@Override
	public List<Departments> getAllDepartments() {
		return departmentRepostiory.findAll();
	}

}
