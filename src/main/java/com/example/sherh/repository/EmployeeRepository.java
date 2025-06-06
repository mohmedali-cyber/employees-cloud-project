package com.example.sherh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sherh.atrbrut.Employee;


@Repository

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	 List<Employee> findByEmployeeNumberContainingIgnoreCase(String employeeNumber);
	    List<Employee> findByEnameContainingIgnoreCase(String ename);
}
