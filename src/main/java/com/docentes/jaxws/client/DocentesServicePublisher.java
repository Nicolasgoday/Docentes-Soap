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
    	// PARA local VA ASI
        /*
    	String port = "8081";
         String host = "http://localhost";
         */
    	
         /*
        HttpHeaders headers = new HttpHeaders();

        HttpEntity request = new HttpEntity(headers);
        
      
        request.getBody();
        System.out.println(request.getBody());

        System.out.print(System.getenv("JDBC_DATABASE_URL"));
        */
         String uri = "/docentesSoap";
         Endpoint.publish(host + ":" + port + uri ,
                 new DocentesServiceSoapImpl());                              


    }
}