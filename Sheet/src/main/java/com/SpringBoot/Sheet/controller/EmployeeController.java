package com.SpringBoot.Sheet.controller;

import com.SpringBoot.Sheet.domain.Employee;
import com.SpringBoot.Sheet.dto.ApiResponse;
import com.SpringBoot.Sheet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> uploadEmployeesData(@RequestParam("file") MultipartFile file){
        try {
            employeeService.saveEmployee(file);
            List<Employee> employees = employeeService.getAllEmployeeDetails();
            return ResponseEntity.ok(new ApiResponse("success", "200", "Employee data added successfully",employees));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(new ApiResponse("error", "500", "An error occurred while processing the file",null));
        }
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<ApiResponse> getEmployeesData(){
        List<Employee> employees = employeeService.getAllEmployeeDetails();
        ApiResponse responseData;
        if (employees.isEmpty()) {
            responseData = new ApiResponse("success", "200", "No Employee data available", employees);
        } else {
            responseData = new ApiResponse("success", "200", "Employee data retrieved successfully", employees);
        }
        return ResponseEntity.ok(responseData);
    }
}
