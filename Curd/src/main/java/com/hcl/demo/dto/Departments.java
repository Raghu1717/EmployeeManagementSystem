package com.hcl.demo.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Departments implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departNo;
    
	
	private String departName;

	
	  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	  "dep") 
	  private DepartmentEmp deptEmp;
	  
	  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	  "dep") 
	  private DepartmentManager depMng;
	 

	public int getDepartNo() {
		return departNo;
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

	public DepartmentEmp getDeptEmp() {
		return deptEmp;
	}

	public void setDeptEmp(DepartmentEmp deptEmp) {
		this.deptEmp = deptEmp;
	}

	public DepartmentManager getDepMng() {
		return depMng;
	}

	public void setDepMng(DepartmentManager depMng) {
		this.depMng = depMng;
	}

}
