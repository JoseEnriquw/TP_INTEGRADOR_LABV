package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.IClienteDao;
import frgp.utn.edu.ar.dao.INacionalidadDao;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ENacionalidad;
import frgp.utn.edu.ar.servicio.IClienteServicio;

public class ClienteServicioImpl implements IClienteServicio {

	private IClienteDao dataAccess=null;
	private INacionalidadDao dataAccessNacionalidad = null;

	public void setDataAccessNacionalidad(INacionalidadDao dataAccessNacionalidad) {
		this.dataAccessNacionalidad = dataAccessNacionalidad;
	}

	public void setDataAccess(IClienteDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public void altaCliente(ECliente cliente) {
	dataAccess.insert(cliente);
	}

	@Override
	public ArrayList<ECliente> listadoClientes() {
	return dataAccess.getAll();	
	}

	@Override
	public ECliente obtenerCliente(Integer id) {
		return dataAccess.get(id);
	}

	@Override
	public void bajaCliente(Integer id) {
		dataAccess.delete(new ECliente(id));
	}

	@Override
	public void modificarCliente(ECliente cliente) {
		dataAccess.update(cliente);
	}
	
	@Override
	public ArrayList<ENacionalidad> listadoNacionalidades() {
		return dataAccessNacionalidad.getAll();
	}

	@Override
	public ENacionalidad getNacionalidad(Integer id) {
		return dataAccessNacionalidad.get(id);
	}
}
