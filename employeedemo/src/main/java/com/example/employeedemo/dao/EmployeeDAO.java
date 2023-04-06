package com.example.employeedemo.dao;

import com.example.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
