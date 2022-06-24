package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EUsuario;

public interface IUsuarioServicio {

	ArrayList<EUsuario> obtenerUsuarios();

	EUsuario obtenerUnRegistro(String nombreUser);

	void insertarUsuario(EUsuario usuario);

    void eliminarUsuario(Integer idUser) ;

	void actualizarUsuario(EUsuario usuario);
	
}
