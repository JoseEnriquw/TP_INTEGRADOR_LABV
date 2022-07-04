package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidades.ECliente;

public interface IClienteDao extends IGenericDao<ECliente,Integer>{

	public ECliente getByDni(String dni);
}
