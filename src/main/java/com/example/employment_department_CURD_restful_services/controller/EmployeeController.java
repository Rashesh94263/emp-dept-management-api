package com.example.employment_department_CURD_restful_services.controller;

import com.example.employment_department_CURD_restful_services.dto.EmployeeDto;
import com.example.employment_department_CURD_restful_services.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing employee-related operations.
 *
 * Provides endpoints for creating, retrieving, updating, and deleting employee records within
 * the employment department management system.
 *
 * This controller adheres to RESTful principles:
 *   - GET: Retrieve employee records (individual or all).
 *   - POST: Create a new employee record.
 *   - PUT: Update an existing employee record.
 *   - DELETE: Delete an employee record.
 *
 * Input validation is performed using Spring's validation framework to ensure data integrity.
 * Error handling should be implemented to gracefully manage exceptions and return
 * appropriate error responses to the client.
 */

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    /**
     * Retrieves a single employee record by their ID.
     * @return A ResponseEntity containing the EmployeeDto if found, or a NOT_FOUND status if not found.
     */

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId){

        EmployeeDto employeeDto = employeeService.getEmployeeByID(employeeId);

        return ResponseEntity.ok(employeeDto);

    }

    /**
     * Creates a new employee record.
     * @return A ResponseEntity containing the created EmployeeDto with a CREATED status.
     */
    @PostMapping("/")
    public ResponseEntity<EmployeeDto>  createEmployees(@Validated @RequestBody EmployeeDto employeeDto){

        EmployeeDto createEmployee = employeeService.createEmployeeRecord(employeeDto);

        return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);

    }

    /**
     * Updates an existing employee record.
     * @return A ResponseEntity containing the updated EmployeeDto, or a NOT_FOUND status if not found.
     */

    @PutMapping("/updateEmployeeRecord/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmploeesRecord(@PathVariable long employeeId, @Validated @RequestBody EmployeeDto employeeDto){

        EmployeeDto updatedEmployees = employeeService.updateEmployeeRecord(employeeDto, employeeId);

        return ResponseEntity.ok(updatedEmployees);

    }


    /**
     * Retrieves a list of all employee records.
     * @return A ResponseEntity containing a list of EmployeeDto objects.
     */
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesRecord(){

        List<EmployeeDto> allEmployeeRecord = employeeService.findAllEmployees();

        return ResponseEntity.ok(allEmployeeRecord);
    }


    /**
     * Deletes an employee record by their ID.
     * @return A ResponseEntity with a success message, or a NOT_FOUND status if not found.
     */
    @DeleteMapping("/deleteEmployees/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId){

        employeeService.deleteEmployeeRecord(employeeId);
        return ResponseEntity.ok("Successfully Deleted...") ;

    }



}
