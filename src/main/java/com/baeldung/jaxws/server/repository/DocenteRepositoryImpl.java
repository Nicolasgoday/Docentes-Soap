package com.baeldung.jaxws.server.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.*;
import org.springframework.jdbc.core.JdbcTemplate;

import com.baeldung.jaxws.client.AlumnoCursada;
import com.baeldung.jaxws.client.AlumnoExamenFinal;
import com.baeldung.jaxws.client.Employee;
import com.baeldung.jaxws.client.Materia;
import com.docentes.dao.AlumnosCursadaDao;
import com.docentes.dao.AlumnosExamenFinalDao;
import com.docentes.dao.Materias;
import com.docentes.dao.MateriasDao;

import ch.qos.logback.core.db.DataSourceConnectionSource;

public class DocenteRepositoryImpl implements DocenteRepository {

   public List<Materia> traerMaterias(int idDocente){
	
	   String SQL_QUERY = "SELECT * FROM inscripciones.materias inner join curso on materias.idMaterias = curso.MateriasIdMaterias where JSON_UNQUOTE(datosDocente->\"$.id\") = " + idDocente +" ;";
       List<Materia> listaMat = null;
       try (Connection con = DataSource.getConnection();
           PreparedStatement pst = con.prepareStatement( SQL_QUERY );
           ResultSet rs = pst.executeQuery();) {
       		listaMat = new ArrayList<>();
               Materia m;
               while ( rs.next() ) {
                   m = new Materia();
                   m.setIdMateria(rs.getInt( 1 ) );
                   m.setNombre(rs.getNString( 2 ) );
                   
                   
                   listaMat.add( m );
                   System.out.print("MTARIA ------" + m.getIdMateria());    
               }
               
               
               //CIERRO CONEXION
         //      DataSource.closeConnection();
               
   	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      	   
	   
	return listaMat;
	
}

public List<AlumnoCursada> listadoAlumnosPorMateria(int idDocente, int idMateria){
	//idalumnosCursada, datosAlumno, notaCursada, MateriasIdMaterias, recordatorio, createdAt, updatedAt

	   String SQL_QUERY ="SELECT idalumnosCursada,datosAlumno,notaCursada, alumnoscursada.MateriasIdMaterias  FROM inscripciones.alumnoscursada " + 
	   		"inner join curso on alumnoscursada.MateriasIdMaterias = curso.MateriasIdMaterias " + 
	   		"where alumnoscursada.MateriasIdMaterias = " + idMateria  + " and JSON_UNQUOTE(datosDocente->\"$.id\") = "+ idDocente + " ;" ;
	   
	   System.out.print(SQL_QUERY);
	   
       List<AlumnoCursada> listaAlumno = null;
       try (Connection con = DataSource.getConnection();
           PreparedStatement pst = con.prepareStatement( SQL_QUERY );
           ResultSet rs = pst.executeQuery();) {
    	   listaAlumno = new ArrayList<>();
    	   AlumnoCursada a;
               while ( rs.next() ) {
                   a = new AlumnoCursada();
                   a.setIdalumnosCursada(rs.getInt( 1 ) );
                   a.setDatosAlumno(rs.getNString( 2 ) );
                   a.setNotaCursada(rs.getInt( 3 ) );
                   a.setMateriasIdMaterias(rs.getInt( 4 ) );                   
                   
                   listaAlumno.add( a );
                   
                   System.out.print("Alumno ->" + a.getDatosAlumno());
               }
               
               
               //CIERRO CONEXION
         //      DataSource.closeConnection();
               
   	} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}      	   
		   
		return listaAlumno;
		
}

public boolean cargaNotasCursada(int idDocente, int idMateria, List<AlumnoCursada> alumnosConNotas){
	
	boolean resultado = false;
	
	AlumnosCursadaDao daoAlumnoCursada = new AlumnosCursadaDao(new JdbcTemplate(DataSource.getDataSource()));
	//updateNotaAlumnoCursada
	   
   Iterator<AlumnoCursada> itAlumnos = alumnosConNotas.iterator();
	   
   try {
	   while (itAlumnos.hasNext()) {
		   
		   AlumnoCursada a = itAlumnos.next();
		   System.out.print(a.getDatosAlumno());
		   daoAlumnoCursada.updateNotaAlumnoCursada(a);
		   resultado=true;
	   }   
   }catch (Exception e) {
	   System.out.print(e.getMessage());
	   resultado=false;
}
      
   return resultado;
		

}
 
    public boolean cargaNotasFinales(int idDocente, int idMateria, List<AlumnoExamenFinal> alumnosConNotas){
    	boolean resultado = false;
    	
    	AlumnosExamenFinalDao daoAlumnoExamen = new AlumnosExamenFinalDao(new JdbcTemplate(DataSource.getDataSource()));
    	//updateNotaAlumnoCursada
    	   
       Iterator<AlumnoExamenFinal> itAlumnos = alumnosConNotas.iterator();
    	   
       try {
    	   while (itAlumnos.hasNext()) {
    		   
    		   AlumnoExamenFinal a = itAlumnos.next();
    		   System.out.print(a.getDatosAlumno());
    		   daoAlumnoExamen.updateNotaAlumnoExamenFinal(a);
    		   resultado=true;
    	   }   
       }catch (Exception e) {
    	   System.out.print(e.getMessage());
    	   resultado=false;
    }
          
       return resultado;
		
    
    }

	@Override
	public List<Materia> TraerMateriasDocente(int idDocente) {
		// TODO Auto-generated method stub
		return null;
	}

}