package com.example.empmanager.controller;

import com.example.empmanager.exception.UserNotFoundException;
import com.example.empmanager.model.Employee;
import com.example.empmanager.service.EmployService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeControler {
    private final EmployService employService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:53842")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")

    @CrossOrigin(origins = "http://localhost:53842")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws UserNotFoundException {
        Employee employee = employService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @PostMapping

    @CrossOrigin(origins = "http://localhost:53842")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
        employService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping

    @CrossOrigin(origins = "http://localhost:53842")
    public ResponseEntity<Void> updateEmployee (@RequestBody Employee employee){
        employService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")

    @CrossOrigin(origins = "http://localhost:53842")
    public ResponseEntity<Void> deleteEmployee (@PathVariable Long id){
        employService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
