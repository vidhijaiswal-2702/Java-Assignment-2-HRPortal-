package com.example.hr_portal.service;


import com.example.hr_portal.model.Employee;
import com.example.hr_portal.repository.EmployeeRepository;

import com.example.hr_portal.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee update(Long id, Employee updatedEmployee) {
        Employee existing = getById(id); // throws exception if not found
        existing.setFullName(updatedEmployee.getFullName());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setSalary(updatedEmployee.getSalary());
        return employeeRepo.save(existing);
    }

    public void delete(Long id) {
        Employee employee = getById(id); // throws exception if not found
        employeeRepo.delete(employee);
    }
}
