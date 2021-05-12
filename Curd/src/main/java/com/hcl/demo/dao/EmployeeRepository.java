package com.hcl.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.dto.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	
	List<Employee> findByBirthDate(LocalDate birthDate);
	
	List<Employee> findByLastName(String firstName);
	
	List<Employee> findByGender(String lastName);
	
	List<Employee> findByFirstName(String firstName);

}
 