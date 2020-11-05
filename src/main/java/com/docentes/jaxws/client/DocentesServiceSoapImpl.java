package com.docentes.jaxws.client;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

import com.docentes.jaxws.repository.DocenteRepositoryImpl;
import com.docentes.model.AlumnoCursada;
import com.docentes.model.AlumnoExamenFinal;
import com.docentes.model.Materia;

@WebService(endpointInterface = "com.docentes.jaxws.client.DocentesServiceSoap")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING) 
public class DocentesServiceSoapImpl {
	 @Inject 
    private DocenteRepositoryImpl docenteRepositoryImpl;
	 
	 public DocentesServiceSoapImpl() {
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
