package com.example.employment_department_CURD_restful_services.Mapper;

import com.example.employment_department_CURD_restful_services.dto.EmployeeDto;
import com.example.employment_department_CURD_restful_services.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto employeeToDto(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());

        return employeeDto;
    }


    public static Employee dtoToEntity(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());

        return employee;
    }
}
