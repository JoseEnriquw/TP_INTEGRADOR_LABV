package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ELibro;

public interface IBibliotecaDao extends IGenericDao<EBiblioteca,Integer>{
	public ArrayList<ELibro> ObtenerListadoBiblioteca();
	
	public EBiblioteca obtenerbiblioteca(Integer idlibro);
}
