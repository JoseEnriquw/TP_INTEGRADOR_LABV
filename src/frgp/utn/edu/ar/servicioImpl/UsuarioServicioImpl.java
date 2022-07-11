package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.IUsuarioDao;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.EUsuario;
import frgp.utn.edu.ar.servicio.IUsuarioServicio;

public class UsuarioServicioImpl implements IUsuarioServicio{

	private IUsuarioDao dataAccess = null;
	@Autowired
	public void setDataAccess(IUsuarioDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<EUsuario> listadoUsuarios() {
		return dataAccess.getAll();
	}

	@Override
	public EUsuario obtenerUnRegistro(String nombreUser) {
		return dataAccess.getByName(nombreUser);
	}

	@Override
	public void altaUsuario(EUsuario usuario) {
		 dataAccess.insert(usuario);
	}

	@Override
	public void bajaUsuario(Integer idUser) {
		dataAccess.delete(new EUsuario(idUser));
	}

	@Override
	public void actualizarUsuario(EUsuario usuario) {
		dataAccess.update(usuario);
	}
	
	@Override
	public void modificarUsuario(EUsuario usuario) {
		dataAccess.update(usuario);
	}
	

}
