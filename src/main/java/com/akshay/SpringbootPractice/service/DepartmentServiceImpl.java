package com.akshay.SpringbootPractice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.SpringbootPractice.exception.DepartmentNotFoundException;
import com.akshay.SpringbootPractice.models.Department;
import com.akshay.SpringbootPractice.repo.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department dept) {
		
		return departmentRepository.save(dept);
	}
	
	@Override
	public List<Department> getDepartmentList(){
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long deparmentId) throws DepartmentNotFoundException {
		Optional<Department> dept = departmentRepository.findById(deparmentId);
		if(!dept.isPresent())
			throw new DepartmentNotFoundException("department not found...");
		
		return dept.get();
	}
	
	@Override
	public void deleteDepartmentById(Long deparmentId) {
		 departmentRepository.deleteById(deparmentId);
	}
	
	@Override
	public Department updateDepartment(Long deparmentId, Department department) {
		Department deptInDb = departmentRepository.findById(deparmentId).get();
		deptInDb.setDepartmentName(department.getDepartmentName());
		deptInDb.setDepartmentAddress(department.getDepartmentAddress());
		deptInDb.setDepartmentCode(department.getDepartmentCode());
		
		return departmentRepository.save(deptInDb);
	}
	
	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}
	
	@Override
	public Department getDepartmentByCode(String departmentCode) {
		return departmentRepository.findBySpecificCode(departmentCode);
	}
}
