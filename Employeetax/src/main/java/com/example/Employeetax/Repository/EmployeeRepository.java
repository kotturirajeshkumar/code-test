package com.example.Employeetax.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employeetax.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	

}
