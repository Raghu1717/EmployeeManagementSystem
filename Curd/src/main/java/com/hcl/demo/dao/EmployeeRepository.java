package com.hcl.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.dto.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
