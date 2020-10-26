package com.baeldung.jaxws.client;

import javax.xml.ws.Endpoint;

public class EmployeeServicePublisher {
    public static void main(String[] args) {
        
        Endpoint.publish("http://0.0.0.0/employeeservice", 
          new EmployeeServiceImpl());
    }
}