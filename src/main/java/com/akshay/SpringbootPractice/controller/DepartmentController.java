package com.akshay.SpringbootPractice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.SpringbootPractice.models.Department;
import com.akshay.SpringbootPractice.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department dept) {  //@valid will validate against validation in dept class
		//DepartmentService departmentService = new DepartmentServiceImpl();
		LOGGER.info("saving department...");
		
		return departmentService.saveDepartment(dept);
	}

	@GetMapping("/departments")
	public List<Department> getDepartmentList(){
		return departmentService.getDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id){
		return departmentService.getDepartmentById(id);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id) {

		departmentService.deleteDepartmentById(id);
		return "department deleted successfully";
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {

		return departmentService.updateDepartment(id, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String name){
		return departmentService.getDepartmentByName(name);
	}
	
	@GetMapping("/departments/code/{code}")
	public Department getDepartmentByCode(@PathVariable("code") String code){
		return departmentService.getDepartmentByCode(code);
	}
}
