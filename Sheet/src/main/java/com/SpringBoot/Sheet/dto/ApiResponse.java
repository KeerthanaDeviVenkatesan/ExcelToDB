package com.SpringBoot.Sheet.dto;

import com.SpringBoot.Sheet.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String status;
    private String error_code;
    private String message;
    private List<Employee> data;
}
