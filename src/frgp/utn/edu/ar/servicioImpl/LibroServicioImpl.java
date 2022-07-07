package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import frgp.utn.edu.ar.dao.IGeneroDao;
import frgp.utn.edu.ar.dao.ILibroDao;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.servicio.ILibroServicio;

public class LibroServicioImpl implements ILibroServicio {
	
	private ILibroDao dataAccess;
	private IGeneroDao dataAccessGenero;
	
	public void setDataAccess(ILibroDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public void setDataAccessGenero(IGeneroDao dataAccessGenero) {
		this.dataAccessGenero = dataAccessGenero;
	}
	
	@Override
	public void altaLibro(ELibro Libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ELibro> listadoLibros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bajaLibro(ELibro Libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ELibro obtenerLibro(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarLibro(ELibro libro) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<EGenero> listadoGenero() {
		return dataAccessGenero.getAll();
	}

}
