package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.IClienteDao;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.EUsuario;
import frgp.utn.edu.ar.utiles.Util;

public class ClienteDaoImpl extends GenericDaoImpl<ECliente,Integer> implements IClienteDao{

	@Override
	public ECliente getByDni(String dni) {
		
		return (ECliente) this.hibernateTemplate.find(Util.Q_CLIENTE_BY_DNI,dni).get(0);
		
	}

	
	@Override	
	public ECliente getByName(String dni) {
		return this.hibernateTemplate.get(ECliente.class, dni);
	}
}
