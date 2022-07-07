package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;


public interface ILibroServicio {

	public void altaLibro(ELibro Libro);
	
	public ArrayList<ELibro> listadoLibros();
	
	public void bajaLibro(ELibro Libro);
	
	public ELibro obtenerLibro(Integer id);
	
	public void modificarLibro(ELibro libro);
	
	public ArrayList<EGenero> listadoGenero();
	
}