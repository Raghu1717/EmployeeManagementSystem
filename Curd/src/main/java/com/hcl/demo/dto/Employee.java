package com.hcl.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Embeddable
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(insertable = false, updatable = false)
	private long emp_no;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDate birthDate;

	private String firstName;

	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDate hireDate;

	@OneToMany(targetEntity = DepartmentEmp.class, orphanRemoval = true, mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Embedded
	private List<DepartmentEmp> dep_emp;

	@OneToOne(targetEntity = Salaries.class, orphanRemoval = true, mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Salaries salary;

	@OneToOne(targetEntity = Titles.class, orphanRemoval = true, mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Titles titles;

	@OneToMany(targetEntity = DepartmentManager.class, orphanRemoval = true, mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Embedded
	private List<DepartmentManager> dept_manager;

	public long getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(long emp_no) {
		this.emp_no = emp_no;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Salaries getSalary() {
		return salary;
	}

	public void setSalary(Salaries salary) {
		this.salary = salary;
	}

	public List<DepartmentEmp> getDep_emp() {
		return dep_emp;
	}

	public void setDep_emp(List<DepartmentEmp> dep_emp) {
		this.dep_emp = dep_emp;
	}

	public List<DepartmentManager> getDept_manager() {
		return dept_manager;
	}

	public void setDept_manager(List<DepartmentManager> dept_manager) {
		this.dept_manager = dept_manager;
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

}
