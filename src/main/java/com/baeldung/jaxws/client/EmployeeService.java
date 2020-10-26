package com.baeldung.jaxws.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.baeldung.jaxws.wsdl.com.baeldung.jaxws.server.topdown.ObjectFactory;

@WebService
public interface EmployeeService {
@WebMethod
Employee getEmployee(int id) throws Exception;

@WebMethod
Employee updateEmployee(int id, String name);

@WebMethod
boolean deleteEmployee(int id);

@WebMethod
Employee addEmployee(int id, String name);

// ...
}