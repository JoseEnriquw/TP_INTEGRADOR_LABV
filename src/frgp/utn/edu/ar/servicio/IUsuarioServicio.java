package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EUsuario;

public interface IUsuarioServicio {

	public ArrayList<EUsuario> listadoUsuarios();

	EUsuario obtenerUnRegistro(String nombreUser);

	public void altaUsuario(EUsuario usuario);

    public void bajaUsuario(Integer idUser) ;

	public void actualizarUsuario(EUsuario usuario);
	
	public void modificarUsuario(EUsuario usuario);
	
	
	
}
