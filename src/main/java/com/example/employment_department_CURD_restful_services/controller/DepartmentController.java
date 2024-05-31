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


@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/createNewDeparment")
    public ResponseEntity createDepartmentRecord(@Validated @RequestBody DepartmentDto departmentDto){

            DepartmentDto createDepartment = departmentService.createDepartment(departmentDto);
            return new ResponseEntity<>(createDepartment, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long id){

        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto, id);


        return ResponseEntity.ok(updatedDepartment) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@RequestBody DepartmentDto departmentDto, @PathVariable Long id){

        DepartmentDto relatedDepartment = departmentService.getDepatmentById(id);

        return ResponseEntity.ok(relatedDepartment) ;
    }

    // Fetch all the departments
    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){

        List<DepartmentDto> departmentDtos = departmentService.getAllDepartment();

        return ResponseEntity.ok(departmentDtos) ;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){

         departmentService.deleteDepartment(id);

        return ResponseEntity.ok("Successfully Deleted...") ;
    }

}
