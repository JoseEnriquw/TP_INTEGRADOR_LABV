package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.entidades.EPrestamo;


public interface IPrestamoServicio {
	
	public void  altaPrestamo(EPrestamo prestamo) ;
	
	public  ArrayList<EPrestamo> listadoPrestamos() ;
	
	ArrayList<EPrestamo> getAllWhere(Object obj);

	ECliente ExisteCliente(String dni);

	ArrayList<ELibro> listadolibrosselect();

	EBiblioteca ObtenerBiblioteca(Integer idlibro);

	void EditarBiblioteca(EBiblioteca biblioteca);

	void bajaPrestamo(EPrestamo prestamo);

	EBiblioteca ObtenerBibliotecabyid(Integer id);

	public EPrestamo obtenerPrestamobyID(Integer id) ;

	void EditarPrestamo(EPrestamo prestamo);
}
