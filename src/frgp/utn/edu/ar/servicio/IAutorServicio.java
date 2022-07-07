package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.entidades.ENacionalidad;

public interface IAutorServicio {

	public void altaAutor(EAutor Autor);
	
	public ArrayList<EAutor> listadoAutores();
	
	public void bajaAutor(EAutor Autor);
	
	public EAutor obtenerAutor(Integer id);
	
	public void modificarAutor(EAutor autor);
	
	public ArrayList<ENacionalidad> listadoNacionalidades();
	
	public ENacionalidad getNacionalidad(Integer id) ;
	
}
