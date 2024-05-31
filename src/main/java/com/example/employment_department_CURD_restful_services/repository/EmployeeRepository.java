package com.example.employment_department_CURD_restful_services.repository;

import com.example.employment_department_CURD_restful_services.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
