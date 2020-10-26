package com.baeldung.jaxws.client;

import javax.xml.ws.Endpoint;

public class EmployeeServicePublisher {
    public static void main(String[] args) {
        
        Endpoint.publish("http://docentes-soap-api.herokuapp.com/employeeservice", 
          new EmployeeServiceImpl());
    }
}