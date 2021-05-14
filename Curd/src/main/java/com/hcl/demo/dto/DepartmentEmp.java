package com.hcl.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DepartmentEmp implements Serializable {
	@EmbeddedId
	private CompisteKey id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;

	@Id
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_id", nullable = false, referencedColumnName = "emp_no")
	private Employee emp;

	@Id
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dep_id", nullable = false, referencedColumnName = "departNo")
	private Departments dep;

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Departments getDep() {
		return dep;
	}

	public void setDep(Departments dep) {
		this.dep = dep;
	}

}
