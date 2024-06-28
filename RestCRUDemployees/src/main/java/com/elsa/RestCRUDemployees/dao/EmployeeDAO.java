package com.elsa.RestCRUDemployees.dao;

import com.elsa.RestCRUDemployees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
