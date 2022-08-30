package com.akshay.SpringbootPractice.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.akshay.SpringbootPractice.exception.DepartmentNotFoundException;
import com.akshay.SpringbootPractice.models.Department;
import com.akshay.SpringbootPractice.service.DepartmentService;

@WebMvcTest(DepartmentController.class)                              //to test this class by calling the endpoint through code
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() throws Exception {
		department = new Department(1L, "history", "3rd floor", "HIST");
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDept = new Department();
		inputDept.setDepartmentName("history");
		inputDept.setDepartmentCode("HIST");
		inputDept.setDepartmentAddress("3rd floor");
		
		Mockito.when(departmentService.saveDepartment(inputDept)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"departmentName\": \"history\",\r\n"
						+ "    \"departmentAddress\": \"3rd floor\",\r\n"
						+ "    \"departmentCode\":\"HIST\"\r\n"
						+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
		
	}

	@Test
	void testGetDepartmentById() throws Exception {
		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
		
	}

}
