package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import frgp.utn.edu.ar.dao.IBibliotecaDao;
import frgp.utn.edu.ar.dao.IClienteDao;
import frgp.utn.edu.ar.dao.INacionalidadDao;
import frgp.utn.edu.ar.dao.IPrestamoDao;
import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.entidades.EPrestamo;
import frgp.utn.edu.ar.servicio.IPrestamoServicio;


public class PrestamoServicioImpl implements IPrestamoServicio {
	
	private IPrestamoDao dataAccess = null;
	private IClienteDao dataAccessCliente = null;
	private IBibliotecaDao dataAccessBiblioteca = null;
	
	
	@Autowired
	public void setDataAccess(IPrestamoDao dataAccess ) {
		this.dataAccess = dataAccess;		
	}
	
	public void setDataAccessCliente(IClienteDao dataAccessCliente) {
		this.dataAccessCliente = dataAccessCliente;
	}
	
	public void setDataAccessBiblioteca(IBibliotecaDao dataAccessBiblioteca) {
		this.dataAccessBiblioteca = dataAccessBiblioteca;
	}
	
	@Override
	public void altaPrestamo(EPrestamo prestamo) {
		dataAccess.insert(prestamo);
		
	}

	@Override
	public void bajaPrestamo(EPrestamo prestamo) {
		dataAccess.delete(prestamo);
		
	}
	
	@Override
	public void EditarPrestamo(EPrestamo prestamo) {
		dataAccess.update(prestamo);
		
	}
	
	@Override
	public EPrestamo obtenerPrestamobyID(Integer id) {
		return dataAccess.get(id);
		
	}
	
	@Override
	public ArrayList<EPrestamo> listadoPrestamos() {
	return dataAccess.getAll();	
	}
	
	@Override
	public ArrayList<ELibro> listadolibrosselect() {
	return dataAccessBiblioteca.ObtenerListadoBiblioteca();	
	}
	
	@Override
	public ECliente ExisteCliente(String dni) {	
		
	return dataAccessCliente.getByDni(dni);	
	}
	
	@Override
	public EBiblioteca ObtenerBiblioteca(Integer idlibro) {	
		
	return dataAccessBiblioteca.obtenerbiblioteca(idlibro);	
	}
	
	@Override
	public EBiblioteca ObtenerBibliotecabyid(Integer id) {	
		
	return dataAccessBiblioteca.get(id);	
	}
	
	
	@Override
	public ArrayList<EPrestamo> getAllWhere(Object obj) {
	/*	 DetachedCriteria criteria = new DetachedCriteria("from EPrestamo where" + obj);
		  
		this.hibernateTemplate.findByCriteria(criteria);*/
		return null;
	}

	@Override
	public void EditarBiblioteca(EBiblioteca biblioteca) {
		dataAccessBiblioteca.update(biblioteca);
		
	}

	
}
