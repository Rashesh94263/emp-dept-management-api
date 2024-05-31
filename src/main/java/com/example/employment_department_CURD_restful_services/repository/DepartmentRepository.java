package com.example.employment_department_CURD_restful_services.repository;

import com.example.employment_department_CURD_restful_services.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
