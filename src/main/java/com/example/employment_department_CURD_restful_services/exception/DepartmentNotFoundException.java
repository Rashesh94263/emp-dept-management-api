package com.example.employment_department_CURD_restful_services.exception;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
