package com.baeldung.jaxws.client;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import com.baeldung.jaxws.server.repository.EmployeeRepository;
import com.baeldung.jaxws.server.repository.EmployeeRepositoryImpl;

@WebService(endpointInterface = "com.baeldung.jaxws.client.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

@Inject 
private EmployeeRepository employeeRepositoryImpl;



public EmployeeServiceImpl() {
	super();
	employeeRepositoryImpl = new EmployeeRepositoryImpl();
}

@WebMethod
public Employee getEmployee(int id) {
    return employeeRepositoryImpl.getEmployee(id);
}

@WebMethod
public Employee updateEmployee(int id, String name) {
    return employeeRepositoryImpl.updateEmployee(id, name);
}

@WebMethod
public boolean deleteEmployee(int id) {
    return employeeRepositoryImpl.deleteEmployee(id);
}

@WebMethod
public Employee addEmployee(int id, String name) {
	
    return employeeRepositoryImpl.addEmployee(id, name);
}

// ...}
}