package frgp.utn.edu.ar.daoImpl;

import frgp.utn.edu.ar.dao.IClienteDao;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.utiles.Util;

public class ClienteDaoImpl extends GenericDaoImpl<ECliente,Integer> implements IClienteDao{

	@Override
	public ECliente getByDni(String dni) {
		
		return (ECliente) this.hibernateTemplate.find(Util.Q_CLIENTE_BY_DNI,dni).get(0);
	}

}
