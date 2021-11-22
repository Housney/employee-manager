package com.hosny.employeemanager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hosny.employeemanager.model.Employee;
import com.hosny.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService empolyeeService;

	public EmployeeController(EmployeeService empolyeeService) {
		this.empolyeeService = empolyeeService;
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return this.empolyeeService.findAllEmployees();
	}
	
	@GetMapping("/find/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id){
		return this.empolyeeService.findEmployeeById(id);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.empolyeeService.addEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.empolyeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		 this.empolyeeService.deleteEmployee(id);
	}
}
