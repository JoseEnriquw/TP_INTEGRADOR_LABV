package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EPrestamo;

public interface IPrestamoDao extends IGenericDao<EPrestamo,Integer> {
	ArrayList<EPrestamo>getAllWhere(Object obj );
    
}
