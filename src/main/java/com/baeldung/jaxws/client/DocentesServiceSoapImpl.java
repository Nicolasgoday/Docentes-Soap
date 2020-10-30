package com.baeldung.jaxws.client;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;


import com.baeldung.jaxws.server.repository.DocenteRepositoryImpl;


@WebService(endpointInterface = "com.baeldung.jaxws.client.DocentesServiceSoap")
public class DocentesServiceSoapImpl {
	 @Inject 
    private DocenteRepositoryImpl docenteRepositoryImpl;
	 
	 public DocentesServiceSoapImpl() {
			super();
			this.docenteRepositoryImpl = new DocenteRepositoryImpl();
		}
	 
	  @WebMethod
	  public List<Materia> traerMaterias(int idDocente) {
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
}
