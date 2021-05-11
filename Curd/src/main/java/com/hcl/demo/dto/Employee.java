package com.hcl.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Employee implements Serializable {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long emp_no;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	private String firstName;

	private String lastName;

	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate hireDate;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "emp")
	private Salaries salary;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "emp")
	private Titles title;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "emp")
	private DepartmentManager departmentManager;
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "emp")
	private DepartmentEmp departEmp;

	public Salaries getSalary() {
		return salary;
	}

	public void setSalary(Salaries salary) {
		this.salary = salary;
	}

	public Titles getTitle() {
		return title;
	}

	public void setTitle(Titles title) {
		this.title = title;
	}

	public DepartmentManager getDepartmentmanager() {
		return departmentManager;
	}

	public void setDepartmentmanager(DepartmentManager departmentmanager) {
		this.departmentManager = departmentManager;
	}

	public DepartmentEmp getDepartemp() {
		return departEmp;
	}

	public void setDepartemp(DepartmentEmp departemp) {
		this.departEmp = departEmp;
	}

	public long getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(long emp_no) {
		this.emp_no = emp_no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
