package com.example.employment_department_CURD_restful_services.Mapper;

import com.example.employment_department_CURD_restful_services.dto.DepartmentDto;
import com.example.employment_department_CURD_restful_services.model.Department;

public class DepartmentMapper {


    // Converts Department to DepartmentDto
    public static DepartmentDto toDto(Department department){


        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDescription(department.getDescription());
        departmentDto.setCreatedAt(department.getCreatedAt());
        departmentDto.setUpdatedAt(department.getUpdatedAt() );

        return departmentDto;
    }

    //Convert DepartmentDto to Department

    public static Department toEntity(DepartmentDto departmentDto){

        Department department = new Department();

        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDescription(departmentDto.getDescription());
        department.setCreatedAt(department.getCreatedAt());
        department.setUpdatedAt(department.getUpdatedAt());

        return department;
    }

}
