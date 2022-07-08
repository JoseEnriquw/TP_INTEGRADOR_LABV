package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.ECliente;

public interface IClienteServicio {

	public void altaCliente(ECliente cliente);
	public ECliente obtenerCliente(Integer id);
	public ArrayList<ECliente> listadoClientes();
	public void bajaCliente(Integer id);
	public void modificarCliente(ECliente cliente);
	ECliente obtenerUnRegistro(String dni);
}
