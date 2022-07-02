package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.IClienteDao;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.servicio.IClienteServicio;

public class ClienteServicioImpl implements IClienteServicio {

	private IClienteDao dataAccess = null;
	@Autowired
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


}
