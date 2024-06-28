package com.elsa.RestCRUDemployees.dao;

import com.elsa.RestCRUDemployees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
