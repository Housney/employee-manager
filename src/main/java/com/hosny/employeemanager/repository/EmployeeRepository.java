package com.hosny.employeemanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosny.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//jpa would interpret this as "select * from employee where id = <id>"
	Optional<Employee> findEmployeeById(long id);

}
