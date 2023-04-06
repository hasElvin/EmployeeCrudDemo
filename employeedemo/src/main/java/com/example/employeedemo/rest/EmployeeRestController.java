package com.example.employeedemo.rest;

import com.example.employeedemo.entity.Employee;
import com.example.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService =employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping()
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping()
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteById(employeeId);
    }
}
