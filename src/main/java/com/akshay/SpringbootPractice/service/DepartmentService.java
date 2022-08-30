package com.akshay.SpringbootPractice.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.akshay.SpringbootPractice.exception.DepartmentNotFoundException;
import com.akshay.SpringbootPractice.models.Department;

public interface DepartmentService {
	
	public Department saveDepartment(Department dept);
	
	public List<Department> getDepartmentList();
	
	public Department getDepartmentById(Long deparmentId) throws DepartmentNotFoundException;
	
	public void deleteDepartmentById(Long deparmentId);
	
	public Department updateDepartment(Long deparmentId, Department department);
	
	public Department getDepartmentByName(String departmentName);
	
	public Department getDepartmentByCode(String departmentCode);
}
