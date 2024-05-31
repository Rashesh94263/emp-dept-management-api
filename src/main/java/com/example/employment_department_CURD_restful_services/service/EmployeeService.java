package com.example.employment_department_CURD_restful_services.service;
// Imports for DTO, model, repository, mapper, and exceptions
import com.example.employment_department_CURD_restful_services.Mapper.EmployeeMapper;
import com.example.employment_department_CURD_restful_services.dto.EmployeeDto;
import com.example.employment_department_CURD_restful_services.exception.EmployeeNotFoundException;
import com.example.employment_department_CURD_restful_services.model.Employee;
import com.example.employment_department_CURD_restful_services.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer responsible for handling business logic related to employee operations.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Create a new employee record.
     */
    public EmployeeDto createEmployeeRecord(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.dtoToEntity(employeeDto);

        try{

            Employee savedEmployeeDetails = employeeRepository.save(employee) ;

            return EmployeeMapper.employeeToDto(savedEmployeeDetails);

        }catch (DataAccessException err){

            throw new EmployeeNotFoundException("Failed to create employee: "+err.getMessage());
        }

    }

    /**
     * Update an existing employee record
     */
    public EmployeeDto updateEmployeeRecord(EmployeeDto employeeDto, Long employeeId){


        Employee exisitingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Failed to find employee record."));
       exisitingEmployee.setFirstName(employeeDto.getFirstName());
       exisitingEmployee.setLastName(employeeDto.getLastName());
       exisitingEmployee.setEmail(employeeDto.getEmail());

        return  EmployeeMapper.employeeToDto(exisitingEmployee);
    }


    /**
     * Retrieve an employee by their ID.
     */
    public EmployeeDto getEmployeeByID(Long employeeId){

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found..."));
       return EmployeeMapper.employeeToDto(employee);
    }


    /**
     * Delete an employee record by their ID.
     */
    public void deleteEmployeeRecord(Long employeeId){
        try{
            employeeRepository.deleteById(employeeId);
        }catch (DataAccessException err){
         throw new EmployeeNotFoundException("Failed to delelte employee record. ");
        }

    }

    /**
    * Retrieve details of all employees
    */
    public List<EmployeeDto> findAllEmployees(){

        List<Employee> employeesRecords = new ArrayList<>();
        List<EmployeeDto> employeeDtosRecords = new ArrayList<>();

        try {

            employeesRecords = employeeRepository.findAll() ;

            employeeDtosRecords = employeesRecords.stream()
                    .map((employee) -> EmployeeMapper.employeeToDto(employee))
                    .collect(Collectors.toList());

            return employeeDtosRecords;

        } catch (DataAccessException err) {
            throw new EmployeeNotFoundException("Failed to find all the employees: "+err.getMessage());
        }


    }



}
