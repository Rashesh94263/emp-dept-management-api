package com.example.employment_department_CURD_restful_services.service;

// Imports for DTO, model, repository, mapper, exceptions, and Spring utilities

import com.example.employment_department_CURD_restful_services.Mapper.DepartmentMapper;
import com.example.employment_department_CURD_restful_services.dto.DepartmentDto;
import com.example.employment_department_CURD_restful_services.exception.DepartmentNotFoundException;
import com.example.employment_department_CURD_restful_services.model.Department;
import com.example.employment_department_CURD_restful_services.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Service layer responsible for handling business logic related to department operations.
 */
@Service
public class DepartmentService {

    // Injected repository for database interactions.
    @Autowired
    private DepartmentRepository departmentRepository;

    // Create a new department
    public DepartmentDto  createDepartment(DepartmentDto departmentDto){

        Department department = DepartmentMapper.toEntity(departmentDto);

        try{
            Department savedDepartmentDetails = departmentRepository.save(department);

            return DepartmentMapper.toDto(savedDepartmentDetails);
        }catch (DataAccessException err){

           throw new DepartmentNotFoundException("Failed to save new department record: "+err.getMessage());
        }

    }

    // Update an existing department by ID
    public DepartmentDto  updateDepartment(DepartmentDto departmentDto, Long id){

        try{
            // find the related Department by id than Update in to the repository.

            Department existingDepartment = departmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Department not Found "));

            existingDepartment.setDepartmentName(departmentDto.getDepartmentName());
            existingDepartment.setDescription(departmentDto.getDescription());

            Department updatedDepartment = departmentRepository.save(existingDepartment);


            return DepartmentMapper.toDto(updatedDepartment);

        }catch(DataAccessException err){

            throw new DepartmentNotFoundException("Falied to locate the department record details of: "+err.getMessage());

        }

    }


    // Get a department by ID
    public DepartmentDto getDepatmentById(Long id){

        Department department = departmentRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Falied to locate department: "));


        return DepartmentMapper.toDto(department);

    }

    // Get all departments
    public List<DepartmentDto> getAllDepartment(){

        try{

            List<Department> departmentsDetails = departmentRepository.findAll();

            List<DepartmentDto> departmentDtos = new ArrayList<>();

            departmentDtos = departmentsDetails
                    .stream()
                    .map( (department) -> DepartmentMapper.toDto(department) )
                    .collect(Collectors.toList());
            return departmentDtos;

        }catch (DataAccessException err){
            throw new DepartmentNotFoundException("Failed to find all the department records: "+err.getMessage());
        }

    }

    // Delete a department by ID
    public void deleteDepartment(Long id) {

        try{

            departmentRepository.deleteById(id);

        }catch (DataAccessException err){
            throw new DepartmentNotFoundException("Failed to delete the department: "+err.getMessage());
        }


    }

}
