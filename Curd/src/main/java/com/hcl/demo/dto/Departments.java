package com.hcl.demo.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Embeddable
public class Departments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int departNo;

	private String departName;

	@OneToMany(targetEntity = DepartmentEmp.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DepartmentEmp> dept_Emp;

	@OneToMany(targetEntity = DepartmentManager.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DepartmentManager> dept_Mngr;

	public int getDepartNo() {
		return departNo;
	}

	public List<DepartmentEmp> getDept_Emp() {
		return dept_Emp;
	}

	public void setDept_Emp(List<DepartmentEmp> dept_Emp) {
		this.dept_Emp = dept_Emp;
	}

	public List<DepartmentManager> getDept_Mngr() {
		return dept_Mngr;
	}

	public void setDept_Mngr(List<DepartmentManager> dept_Mngr) {
		this.dept_Mngr = dept_Mngr;
	}

	public void setDepartNo(int departNo) {
		this.departNo = departNo;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	/*
	 * public DepartmentEmp getDeptEmp() { return deptEmp; }
	 * 
	 * public void setDeptEmp(DepartmentEmp deptEmp) { this.deptEmp = deptEmp; }
	 * 
	 * public DepartmentManager getDepMng() { return depMng; }
	 * 
	 * public void setDepMng(DepartmentManager depMng) { this.depMng = depMng; }
	 */

}
