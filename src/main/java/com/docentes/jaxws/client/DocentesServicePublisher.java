package com.docentes.jaxws.client;

import javax.xml.ws.Endpoint;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.sun.research.ws.wadl.Request;

public class DocentesServicePublisher {
    public static void main(String[] args) {
    	 
    	/* PARA SUBOIR VA ASI*/
    	
    	String port = System.getenv("PORT");
        String host = System.getenv("HOST_SOAP"); //"http://0.0.0.0:";
        /* *********************************/
    	/* PARA local VA ASI
    	String port = "8080";
         String host = "http://localhost:";
        */ 
    	
       // String uri = "/employeeservice";
           //"http://0.0.0.0:8080/employeeservice", Endpoint.publish(, service);
        //Endpoint.publish("http://0.0.0.0:8080/employeeservice",
//       Endpoint.publish(host + port + uri ,
  //        new EmployeeServiceImpl());
         
        HttpHeaders headers = new HttpHeaders();

        HttpEntity request = new HttpEntity(headers);

        request.getBody();
        System.out.println(request.getBody());

        
         String uri = "/docentesSoap";
         Endpoint.publish(host + ":" + port + uri ,
                 new DocentesServiceSoapImpl());
    }
}