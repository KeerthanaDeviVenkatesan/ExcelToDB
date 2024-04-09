package com.SpringBoot.Sheet.service;

import com.SpringBoot.Sheet.domain.Employee;
import com.SpringBoot.Sheet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(MultipartFile multipartFile) {
        try {
            List<Employee> students = ExcelToDBService.getStudentDetails(multipartFile.getInputStream());
            employeeRepository.saveAll(students);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Employee> getAllEmployeeDetails(){
        return employeeRepository.findAll();
    }

}
