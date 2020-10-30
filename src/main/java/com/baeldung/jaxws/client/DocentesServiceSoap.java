package com.baeldung.jaxws.client;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface DocentesServiceSoap {
	
	  @WebMethod
    List<Materia> traerMaterias(int idDocente);
	 
	@WebMethod
	List<AlumnoCursada> listadoAlumnosPorMateria(int idDocente, int idMateria);
	 
    @WebMethod
    boolean cargaNotasCursada(int idDocente, int idMateria, List<AlumnoCursada> alumnosConNotas);
 
    @WebMethod
    boolean cargaNotasFinales(int idDocente, int idMateria, List<AlumnoExamenFinal> alumnosConNotas);
    
    
}
