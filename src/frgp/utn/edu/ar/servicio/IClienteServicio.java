package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ENacionalidad;

public interface IClienteServicio {

	public void altaCliente(ECliente cliente);
	public ECliente obtenerCliente(Integer id);
	public ArrayList<ECliente> listadoClientes();
	public void bajaCliente(Integer id);
	public void modificarCliente(ECliente cliente);
	ECliente obtenerUnRegistro(String dni);
	public ArrayList<ENacionalidad> listadoNacionalidades();
	public ENacionalidad getNacionalidad(Integer id) ;
}
