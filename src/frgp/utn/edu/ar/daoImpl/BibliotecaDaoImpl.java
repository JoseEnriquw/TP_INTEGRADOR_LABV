package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.dao.IBibliotecaDao;
import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.utiles.Util;

public class BibliotecaDaoImpl extends GenericDaoImpl<EBiblioteca,Integer> implements IBibliotecaDao{

	@Override
	public ArrayList<ELibro> ObtenerListadoBiblioteca() {
		 ArrayList<ELibro> ListadoparaPrestamos = new ArrayList<ELibro>();
		 List<Object[]> listadoquery = (List<Object[]>) this.hibernateTemplate.find(Util.Q_BIBLIOTECA_ARRAY);
		
		 for(Object[] objeto : listadoquery) {
			 ListadoparaPrestamos.add((ELibro)objeto[1]);
		  }
		
		return ListadoparaPrestamos;
	}

	@Override
	public EBiblioteca obtenerbiblioteca(Integer idlibro) {
		
		return (EBiblioteca) this.hibernateTemplate.find(Util.Q_BIBLIOTECA_BY_IDLIBRO,idlibro).get(0);
	}
	
	

}
