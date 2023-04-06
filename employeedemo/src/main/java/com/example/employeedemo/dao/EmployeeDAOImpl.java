package com.example.employeedemo.dao;

import com.example.employeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOImpl() {}

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee", Employee.class);
        return typedQuery.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
