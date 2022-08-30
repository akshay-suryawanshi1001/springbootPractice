package com.akshay.SpringbootPractice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.akshay.SpringbootPractice.models.Department;
import com.akshay.SpringbootPractice.repo.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@BeforeEach
	void setUp() {
		Department dummyDept = new Department(1L, "history", "3rd floor", "HIST");
		
		Mockito.when(departmentRepository.findByDepartmentName("history"))
		.thenReturn(dummyDept);
	}
	
	@Test
	public void getDepartmentByNameTest() {
		String deptName = "history";
		Department foundDept = departmentService.getDepartmentByName(deptName);
		
		assertEquals(deptName, foundDept.getDepartmentName());
	}
}
