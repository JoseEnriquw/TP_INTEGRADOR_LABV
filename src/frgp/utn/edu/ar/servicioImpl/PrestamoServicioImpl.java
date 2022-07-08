package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import frgp.utn.edu.ar.dao.IClienteDao;
import frgp.utn.edu.ar.dao.IPrestamoDao;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.EPrestamo;
import frgp.utn.edu.ar.servicio.IPrestamoServicio;


public class PrestamoServicioImpl implements IPrestamoServicio {
	
	private IPrestamoDao dataAccess = null;
	/*private IClienteDao dataAccess = null;*/
	
	@Autowired
	public void setDataAccess(IPrestamoDao dataAccess/*,IClienteDao dataAccessCliente*/ ) {
		this.dataAccess = dataAccess;
		/*this.dataAccess = dataAccessCliente;*/
	}
	
	@Override
	public void altaPrestamo(EPrestamo prestamo) {
		dataAccess.insert(prestamo);
		
	}

	@Override
	public ArrayList<EPrestamo> listadoPrestamos() {
	return dataAccess.getAll();	
	}
	
	/*@Override
	public ECliente ExisteCliente(String dni) {	
		
	return dataAccess.getByDni(dni);	
	}*/
	
	
	
	@Override
	public ArrayList<EPrestamo> getAllWhere(Object obj) {
		/* DetachedCriteria criteria = new DetachedCriteria("from EPrestamo where" + obj);
		  
		this.hibernateTemplate.findByCriteria(criteria);*/
		return null;
	}

	@Override
	public ECliente ExisteCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
