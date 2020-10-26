package com.baeldung.jaxws.server.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.*;

import com.baeldung.jaxws.client.Employee;
import com.docentes.dao.Materias;
import com.docentes.dao.MateriasDao;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employeeList;
    
    @Autowired
    private MateriasDao m;

    public EmployeeRepositoryImpl() {
    	
    	System.out.print("CREANDO...");
        employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1, "Jane"));
        employeeList.add(new Employee(2, "Jack"));
        employeeList.add(new Employee(3, "George"));
        
        			  
        String SQL_QUERY = "select * from materias";
        List<Materias> listaMat = null;
        try (Connection con = DataSource.getConnection();
            PreparedStatement pst = con.prepareStatement( SQL_QUERY );
            ResultSet rs = pst.executeQuery();) {
        		listaMat = new ArrayList<>();
                Materias m;
                while ( rs.next() ) {
                    m = new Materias();
                    m.setId((long)rs.getInt( 1 ) );
                    
                    
                    listaMat.add( m );
                    System.out.print("MTARIA ------" + m.getId());    
                }
                
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
		return null;
        
    }

    public Employee updateEmployee(int id, String name) {
        for (Employee employee1 : employeeList) {
            if (employee1.getId() == id) {
                employee1.setId(id);
                employee1.setFirstName(name);
                return employee1;
            }
        }
		return null;
    }

    public boolean deleteEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                return true;
            }
        }
		return false;
    
    }

    public Employee addEmployee(int id, String name) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
             
            }
        }
        Employee employee = new Employee(id, name);
        employeeList.add(employee);
        return employee;
    }

    public int count() {
        return employeeList.size();
    }
}