package com.akshay.SpringbootPractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akshay.SpringbootPractice.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findByDepartmentName(String name) ;
	
	@Query(value = "select * from department where department_code = ?1 ", nativeQuery = true)
	Department findBySpecificCode(String code);
}
