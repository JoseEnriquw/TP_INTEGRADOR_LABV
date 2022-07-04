package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import frgp.utn.edu.ar.dao.IPrestamoDao;

import frgp.utn.edu.ar.entidades.EPrestamo;
import frgp.utn.edu.ar.servicio.IPrestamoServicio;


public class PrestamoServicioImpl implements IPrestamoServicio {
	
	private IPrestamoDao dataAccess = null;
	@Autowired
	public void setDataAccess(IPrestamoDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public void altaPrestamo(EPrestamo prestamo) {
	dataAccess.insert(prestamo);
		
	}

	@Override
	public ArrayList<EPrestamo> listadoPrestamos() {
	return dataAccess.getAll();	
	}
	
	@Override
	public ArrayList<EPrestamo> getAllWhere(Object obj) {
		/* DetachedCriteria criteria = new DetachedCriteria("from EPrestamo where" + obj);
		  
		this.hibernateTemplate.findByCriteria(criteria);*/
		return null;
	}

}
