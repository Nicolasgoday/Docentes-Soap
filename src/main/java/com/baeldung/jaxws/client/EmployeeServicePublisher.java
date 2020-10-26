package com.baeldung.jaxws.client;

import javax.xml.ws.Endpoint;

public class EmployeeServicePublisher {
    public static void main(String[] args) {
    	 String port = System.getenv("PORT");
         String host = "http://0.0.0.0:";
         String uri = "/employeeservice";
           //"http://0.0.0.0:8080/employeeservice", Endpoint.publish(, service);
        //Endpoint.publish("http://0.0.0.0:8080/employeeservice",
         Endpoint.publish(host + port + uri ,
          new EmployeeServiceImpl());
    }
}