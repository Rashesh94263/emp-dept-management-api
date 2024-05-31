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

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId){

        EmployeeDto employeeDto = employeeService.getEmployeeByID(employeeId);

        return ResponseEntity.ok(employeeDto);

    }

    @PostMapping("/createEmployeeRecord")
    public ResponseEntity<EmployeeDto>  createEmployees(@Validated @RequestBody EmployeeDto employeeDto){

        EmployeeDto createEmployee = employeeService.createEmployeeRecord(employeeDto);

        return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);

    }

    @PutMapping("/updateEmployeeRecord/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmploeesRecord(@PathVariable long employeeId, @Validated @RequestBody EmployeeDto employeeDto){

        EmployeeDto updatedEmployees = employeeService.updateEmployeeRecord(employeeDto, employeeId);

        return ResponseEntity.ok(updatedEmployees);

    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesRecord(){

        List<EmployeeDto> allEmployeeRecord = employeeService.findAllEmployees();

        return ResponseEntity.ok(allEmployeeRecord);
    }

    @DeleteMapping("/deleteEmployees/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId){

        employeeService.deleteEmployeeRecord(employeeId);
        return ResponseEntity.ok("Successfully Deleted...") ;

    }



}
