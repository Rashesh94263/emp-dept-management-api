package com.example.employment_department_CURD_restful_services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;


}
