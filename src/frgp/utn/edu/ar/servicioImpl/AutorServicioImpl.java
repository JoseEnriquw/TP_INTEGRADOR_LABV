package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.IAutorDao;
import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.servicio.IAutorServicio;

public class AutorServicioImpl implements IAutorServicio{

	private IAutorDao dataAccess = null;
	@Autowired
	public void setDataAccess(IAutorDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public void altaAutor(EAutor Autor) {
		dataAccess.insert(Autor);
		
	}

	@Override
	public ArrayList<EAutor> listadoAutores() {
		return dataAccess.getAll();
	}
	
	@Override
	public void bajaAutor(EAutor autor) {
		dataAccess.delete(autor);
	}

	@Override
	public EAutor obtenerAutor(Integer id) {
		return dataAccess.get(id);
		
	}

	@Override
	public void modificarAutor(EAutor autor) {
		dataAccess.update(autor);
		
	}

}
