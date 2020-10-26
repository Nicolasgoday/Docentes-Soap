package com.baeldung.jaxws.server.repository;

import java.util.List;

import com.baeldung.jaxws.client.Employee;
import com.baeldung.jaxws.client.EmployeeService;


public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    Employee updateEmployee(int id, String name);

    boolean deleteEmployee(int id);

    Employee addEmployee(int id, String name);

    int count();
}