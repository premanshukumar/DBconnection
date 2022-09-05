package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;

	@GetMapping("/hello")
	public String getHello() {

		if (null != repo) {
			return "hello world with DB repo";
		} else {
			return "hello world without DB repo";
		}
	}

	@PostMapping(value = "/employee", consumes = { "application/Json" })
	public Employee addEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}

	@GetMapping(value = "/employees", consumes = { "application/Json" })
	public List<Employee> getEmployees(@RequestBody Employee employee) {
		return repo.findAll();
	}

}
