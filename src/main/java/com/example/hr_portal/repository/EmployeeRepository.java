package com.example.hr_portal.repository;

import com.example.hr_portal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // No custom methods needed for now — basic CRUD comes from JpaRepository
}
