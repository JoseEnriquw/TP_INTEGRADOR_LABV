package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidades.EUsuario;

public interface IUsuarioDao extends IGenericDao<EUsuario,Integer> {

	public EUsuario getByName(String nombreUser);
}
