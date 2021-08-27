package com.mayesha.springboot.crudrestfulwebservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayesha.springboot.crudrestfulwebservices.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long>{

	
	
}
