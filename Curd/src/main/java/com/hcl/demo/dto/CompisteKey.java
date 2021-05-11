package com.hcl.demo.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CompisteKey implements Serializable {

	private long emp_no;

	private int departNo;

	public CompisteKey() {

	}

	public CompisteKey(long emp_no, int departNo) {

		this.emp_no = emp_no;
		this.departNo = departNo;
	}

	public long getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(long emp_no) {
		this.emp_no = emp_no;
	}

	public int getDepartNo() {
		return departNo;
	}

	public void setDepartNo(int departNo) {
		this.departNo = departNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CompisteKey taskId1 = (CompisteKey) o;
		if (emp_no != taskId1.emp_no)
			return false;
		return departNo == taskId1.departNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_no, departNo);
	}

}