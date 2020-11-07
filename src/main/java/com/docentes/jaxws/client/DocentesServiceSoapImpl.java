package com.docentes.jaxws.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.docentes.jaxws.repository.DocenteRepositoryImpl;
import com.docentes.model.AlumnoCursada;
import com.docentes.model.AlumnoExamenFinal;
import com.docentes.model.Materia;
import com.docentes.util.Autentificador;


@WebService(endpointInterface = "com.docentes.jaxws.client.DocentesServiceSoap")
public class DocentesServiceSoapImpl implements DocentesServiceSoap{
	 @Inject 
    private DocenteRepositoryImpl docenteRepositoryImpl;
	 
	 /*
	  @Resource
	  private WebServiceContext wsContext;

	  public void setWsContext(WebServiceContext wsContext) {
	    this.wsContext = wsContext;
	  }
	 */
	 public DocentesServiceSoapImpl() {
			this.docenteRepositoryImpl = new DocenteRepositoryImpl();
		}
	 
	  @WebMethod
	  public List<Materia> traerMaterias(int idDocente) {
		  //RECIBO ENCABEZADO BEARER
			/*
		  MessageContext mctx = wsContext.getMessageContext();
	    	Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);	   
	        List authorization = (List) http_headers.get("Authorization");
	        
	        Autentificador auth = new Autentificador();	        		
	        
	        System.out.print((String)authorization.get(0));
	        //SI NO ES PROFESOR O ESTA MAL FOMRADO  -Z VER PORQE NO DEVUELVE EL ROL
	        if (!auth.autentificar("ES_PROFESOR", (String)authorization.get(0)))
	           	System.out.print("NO AUTH\n");*/    	
		return this.docenteRepositoryImpl.traerMaterias(idDocente);
	  	}
		 
		@WebMethod
		public List<AlumnoCursada> listadoAlumnosPorMateria(int idDocente, int idMateria) {
			return this.docenteRepositoryImpl.listadoAlumnosPorMateria(idDocente, idMateria);
		}	
		
	    @WebMethod
	    public boolean cargaNotasCursada(int idDocente, int idMateria, List<AlumnoCursada> alumnosConNotas) {
	    	return this.docenteRepositoryImpl.cargaNotasCursada(idDocente, idMateria, alumnosConNotas);
		}
	 
	    @WebMethod
	    public boolean cargaNotasFinales(int idDocente, int idMateria, List<AlumnoExamenFinal> alumnosConNotas) {
	    	return this.docenteRepositoryImpl.cargaNotasFinales(idDocente, idMateria, alumnosConNotas);
		}
	    
	    @WebMethod
		public List<AlumnoExamenFinal> traerAlumnosPorMateriaExamen(int idDocente, int idMateria){
			return this.docenteRepositoryImpl.traerAlumnosPorMateriaExamen(idDocente, idMateria);
		}
}
