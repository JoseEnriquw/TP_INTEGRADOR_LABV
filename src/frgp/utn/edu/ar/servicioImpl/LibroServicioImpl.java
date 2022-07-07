package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.IAutorDao;
import frgp.utn.edu.ar.dao.IGeneroDao;
import frgp.utn.edu.ar.dao.ILibroDao;
import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.servicio.ILibroServicio;

public class LibroServicioImpl implements ILibroServicio {
	
	private ILibroDao dataAccess;
	private IGeneroDao dataAccessGenero;
	private IAutorDao dataAccessAutor;
	
	public void setDataAccess(ILibroDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public void setDataAccessGenero(IGeneroDao dataAccessGenero) {
		this.dataAccessGenero = dataAccessGenero;
	}
	
	public void setDataAccessAutor(IAutorDao dataAccessAutor) {
		this.dataAccessAutor = dataAccessAutor;
	}
	
	@Override
	public void altaLibro(ELibro Libro) {
		dataAccess.insert(Libro);
		
	}

	@Override
	public ArrayList<ELibro> listadoLibros() {
		return dataAccess.getAll();
	}

	@Override
	public void bajaLibro(ELibro Libro) {
		dataAccess.delete(Libro);
		
	}

	@Override
	public ELibro obtenerLibro(Integer id) {
		return dataAccess.get(id);
	}

	@Override
	public void modificarLibro(ELibro libro) {
		dataAccess.update(libro);
		
	}
	@Override
	public ArrayList<EGenero> listadoGenero() {
		return dataAccessGenero.getAll();
	}

	@Override
	public EGenero getGenero(Integer id) {
		return dataAccessGenero.get(id);
	}

	@Override
	public ArrayList<EAutor> listadoAutores() {
		return dataAccessAutor.getAll();
	}

	@Override
	public EAutor getAutor(Integer id) {
		return dataAccessAutor.get(id);
	}
	
	

}
