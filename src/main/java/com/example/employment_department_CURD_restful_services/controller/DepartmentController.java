package com.example.employment_department_CURD_restful_services.controller;
import com.example.employment_department_CURD_restful_services.dto.DepartmentDto;
import com.example.employment_department_CURD_restful_services.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for managing department-related operations.
 *
 * Provides endpoints for creating, retrieving, updating, and deleting employee records within
 * the employment department management system.
 *
 * This controller adheres to RESTful principles, using appropriate HTTP methods and status codes
 * for each operation:
 *   - GET: Retrieve department records (individual or all).
 *   - POST: Create a new department record.
 *   - PUT: Update an existing department record.
 *   - DELETE: Delete an department record.
 *
 * Input validation is performed using Spring's validation framework to ensure data integrity.
 * Error handling (not shown) should be implemented to gracefully manage exceptions and return
 * appropriate error responses to the client.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    /**
     * Creates a new department record.
     * @return A ResponseEntity containing the created DepartmentDto with a CREATED status.
     */
    @PostMapping("/")
    public ResponseEntity createDepartmentRecord(@Validated @RequestBody DepartmentDto departmentDto){

            DepartmentDto createDepartment = departmentService.createDepartment(departmentDto);
            return new ResponseEntity<>(createDepartment, HttpStatus.CREATED);

    }

    /**
     * Updates an existing department record.
     * @return A ResponseEntity containing the updated DepartmentDto, or a NOT_FOUND status if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long id){

        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto, id);


        return ResponseEntity.ok(updatedDepartment) ;
    }


    /**
     * Retrieves a single department record by its ID.
     * @return A ResponseEntity containing the DepartmentDto if found, or a NOT_FOUND status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@RequestBody DepartmentDto departmentDto, @PathVariable Long id){

        DepartmentDto relatedDepartment = departmentService.getDepatmentById(id);

        return ResponseEntity.ok(relatedDepartment) ;
    }

    /**
     * Retrieves a list of all department records.
     * @return A ResponseEntity containing a list of DepartmentDto objects.
     */
    @GetMapping("/")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){

        List<DepartmentDto> departmentDtos = departmentService.getAllDepartment();

        return ResponseEntity.ok(departmentDtos) ;

    }

    /**
     * Deletes a department record by its ID.
     * @return A ResponseEntity with a success message, or a NOT_FOUND status if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){

         departmentService.deleteDepartment(id);

        return ResponseEntity.ok("Successfully Deleted...") ;
    }

}
