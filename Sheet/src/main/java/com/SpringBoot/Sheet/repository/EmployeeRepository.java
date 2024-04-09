package com.SpringBoot.Sheet.repository;

import com.SpringBoot.Sheet.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
