package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.IAutorDao;
import frgp.utn.edu.ar.dao.IBibliotecaDao;
import frgp.utn.edu.ar.dao.IGeneroDao;
import frgp.utn.edu.ar.dao.ILibroDao;
import frgp.utn.edu.ar.dao.INacionalidadDao;
import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.servicio.IBibliotecaServicio;

public class BibliotecaServicioImpl implements IBibliotecaServicio{
	private IBibliotecaDao dataAccess = null;
	private ILibroDao dataAccessLibro = null;
	@Autowired
	public void setDataAccess(IBibliotecaDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	public void setDataAccessLibro(ILibroDao dataAccessLibro) {
		this.dataAccessLibro = dataAccessLibro;
	}
		
	@Override
	public void altaBiblioteca(EBiblioteca Biblioteca){
		dataAccess.insert(Biblioteca);
		
	}
	
	@Override
	public ArrayList<EBiblioteca> listadoBiblioteca() {
		return dataAccess.getAll();
	}
	
	@Override
	public ArrayList<ELibro> listadoLibro() {
		// TODO Auto-generated method stub
		return dataAccessLibro.getAll();
	}

	@Override
	public EBiblioteca obtenerBiblioteca(Integer id) {	
		return dataAccess.get(id);
	}

	@Override
	public ELibro obtenerLibro(Integer id) {
		return dataAccessLibro.get(id);
	}

	@Override
	public void bajaBiblioetca(EBiblioteca biblioteca) {
		dataAccess.delete(biblioteca);
		
	}
	
	@Override
	public void modificarBiblioteca(EBiblioteca biblioteca) {
		dataAccess.update(biblioteca);
		
	}

	@Override
	public ArrayList<EBiblioteca> obtenerBibliotecaByEstado(String estado) {
		return dataAccess.obtenerBibliotecaByEstado(estado);
	}




	
}
