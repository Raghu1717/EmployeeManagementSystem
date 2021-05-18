package com.hcl.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.hcl.demo.entity.DepartmentEmp;
import com.hcl.demo.entity.DepartmentManager;
import com.hcl.demo.entity.Departments;
import com.hcl.demo.entity.Employee;
import com.hcl.demo.entity.Salaries;
import com.hcl.demo.entity.Titles;

public class EmployeeRequestUtil {

	public static Employee getEmployee(Employee employeeDTO) {
		Employee employee = new Employee();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setGender(employeeDTO.getGender());
		employee.setHireDate(employeeDTO.getHireDate());
		employee.setBirthDate(employeeDTO.getBirthDate());

		Salaries salaries = getSalaries(employeeDTO, employee);

		Titles titles = getTitles(employeeDTO, employee);

		List<DepartmentEmp> departmentEmployees = getDepartmentEmployees(employeeDTO, employee);

		List<DepartmentManager> departmentManagers = getDepartmentManagers(employeeDTO, employee);

		employee.setSalary(salaries);
		employee.setTitles(titles);
		employee.setDep_emp(departmentEmployees);
		employee.setDept_manager(departmentManagers);
		return employee;

	}

	private static List<DepartmentManager> getDepartmentManagers(Employee employeeDTO, Employee employee) {
		List<DepartmentManager> department_Managers = new ArrayList<>();
		List<DepartmentManager> managerDepartments = employeeDTO.getDept_manager();

		for (DepartmentManager department_ManagerDTO : managerDepartments) {
			DepartmentManager departmentManager = new DepartmentManager();
			departmentManager.setFromDate(department_ManagerDTO.getFromDate());
			departmentManager.setToDate(department_ManagerDTO.getToDate());
			departmentManager.setEmployee(employee);
			department_Managers.add(departmentManager);

		}
		return department_Managers;
	}

	private static List<DepartmentEmp> getDepartmentEmployees(Employee employeeDTO, Employee employee) {
		List<DepartmentEmp> department_Employees = new ArrayList<>();
		List<DepartmentEmp> employeeDepartments = employeeDTO.getDep_emp();
		for (DepartmentEmp department_EmployeeDTO : employeeDepartments) {
			DepartmentEmp department_Employee = new DepartmentEmp();
			department_Employee.setFromDate(department_EmployeeDTO.getFromDate());
			department_Employee.setToDate(department_EmployeeDTO.getToDate());
			department_Employee.setEmployee(employee);
			department_Employee.setDepartment(getDepartment(department_EmployeeDTO, department_Employee));
			department_Employees.add(department_Employee);
		}

		return department_Employees;
	}

	private static Departments getDepartment(DepartmentEmp department_EmployeeDTO, DepartmentEmp department_Employee) {
		List<DepartmentEmp> emp = new ArrayList<>();
		emp.add(department_Employee);
		Departments departments = new Departments();
		departments.setDepartNo(department_EmployeeDTO.getDepartment().getDepartNo());
		departments.setDepartName(department_EmployeeDTO.getDepartment().getDepartName());
		departments.setDept_Emp(emp);
		return departments;
	}

	private static Titles getTitles(Employee employeeDTO, Employee employee) {

		Titles title = new Titles();

		title.setFromDate(employeeDTO.getTitles().getFromDate());
		title.setToDate(employeeDTO.getTitles().getToDate());
		title.setTitle(employeeDTO.getTitles().getTitle());
		title.setEmployee(employee);

		return title;
	}

	private static Salaries getSalaries(Employee dto, Employee employee) {

		Salaries salray = new Salaries();
		salray.setFromDate(dto.getSalary().getFromDate());
		salray.setToDate(dto.getSalary().getToDate());
		salray.setSalary(dto.getSalary().getSalary());
		salray.setEmployee(employee);

		return salray;

	}
}
