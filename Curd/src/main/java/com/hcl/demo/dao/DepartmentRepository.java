package com.hcl.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.dto.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Integer> {


}
