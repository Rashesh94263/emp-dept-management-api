

package com.example.employment_department_CURD_restful_services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartmentDto{

    private Long departmentId;
    private String departmentName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}