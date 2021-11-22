package com.hosny.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hosny.employeemanager.exception.UserNotFoundException;
import com.hosny.employeemanager.model.Employee;
import com.hosny.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	// you can put @Autowired, but it's not required if there is only one
	// constructor
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee findEmployeeById(long id) throws UserNotFoundException{
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found!"));
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
}
