package com.baeldung.jaxws.server.repository;

import java.util.List;

import javax.jws.WebMethod;

import com.baeldung.jaxws.client.AlumnoCursada;
import com.baeldung.jaxws.client.AlumnoExamenFinal;
import com.baeldung.jaxws.client.Employee;
import com.baeldung.jaxws.client.EmployeeService;
import com.baeldung.jaxws.client.Materia;


public interface DocenteRepository {

    List<Materia> TraerMateriasDocente(int idDocente);

   List<Materia> traerMaterias(int idDocente);

	List<AlumnoCursada> listadoAlumnosPorMateria(int idDocente, int idMateria);

    boolean cargaNotasCursada(int idDocente, int idMateria, List<AlumnoCursada> alumnosConNotas);
 
    boolean cargaNotasFinales(int idDocente, int idMateria, List<AlumnoExamenFinal> alumnosConNotas);
}