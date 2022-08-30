package com.akshay.SpringbootPractice.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.akshay.SpringbootPractice.models.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		Department dummyDept = new Department();   //setting id here will give error in test case that PersistentObjectException: detached entity passed to persist so skip id setting the id here
		dummyDept.setDepartmentName("history");
		dummyDept.setDepartmentCode("HIST");
		dummyDept.setDepartmentAddress("3rd floor");
		
		entityManager.persist(dummyDept);  //save mock data
	}
	
	@Test
	public void findByDepartmentNameTest() {
		Department found = departmentRepository.findById(1L).get();
		assertEquals(found.getDepartmentName(), "history");
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
