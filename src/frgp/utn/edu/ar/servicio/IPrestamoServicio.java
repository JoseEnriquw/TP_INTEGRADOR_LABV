package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.EPrestamo;


public interface IPrestamoServicio {
	
	public void  altaPrestamo(EPrestamo prestamo) ;
	
	public  ArrayList<EPrestamo> listadoPrestamos() ;
	
	ArrayList<EPrestamo> getAllWhere(Object obj);
}
