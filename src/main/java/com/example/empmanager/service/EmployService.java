package com.example.empmanager.service;

import com.example.empmanager.exception.UserNotFoundException;
import com.example.empmanager.model.Employee;
import com.example.empmanager.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class EmployService {
    private final EmployeeRepo employeeRepo;

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public void addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeRepo.save(employee);
        log.info("Employee ADDED to DB");
    }

    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
        log.info("Employee ADDED to DB");
    }

    public Employee findEmployeeById(Long id) throws UserNotFoundException {
        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
