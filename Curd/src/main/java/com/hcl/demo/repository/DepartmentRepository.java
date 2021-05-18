package com.hcl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.entity.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Integer> {


}
