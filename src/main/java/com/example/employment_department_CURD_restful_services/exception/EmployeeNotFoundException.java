package com.example.employment_department_CURD_restful_services.exception;

public class EmployeeNotFoundException extends RuntimeException{

    // employee not in the database
    public EmployeeNotFoundException(String message){
        super(message);
    }
}

