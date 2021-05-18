package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.dto.Departments;

public interface DepartmentService {

	public Departments addDepartment(Departments department);

	public Departments updateDepartment(Departments department);

	public void deleteDepartment(int id);

	public Departments getDepartment(int id);

	public void deleteAllDepartment();

	public List<Departments> getAllDepartments();

}
