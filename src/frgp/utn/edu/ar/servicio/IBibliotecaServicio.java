package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ELibro;

public interface IBibliotecaServicio {
	public void altaBiblioteca(EBiblioteca Biblioteca);
	
	public ArrayList<EBiblioteca> listadoBiblioteca();
	
	public ArrayList<ELibro> listadoLibro();
	
/*	public void bajaBiblioteca(EBiblioteca Biblioteca);*/
	
	public EBiblioteca obtenerBiblioteca(Integer id);
	
	public ELibro obtenerLibro(Integer id);
	

}
