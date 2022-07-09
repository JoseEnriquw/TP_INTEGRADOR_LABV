package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.EPrestamo;
import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.entidades.ENacionalidad;
import frgp.utn.edu.ar.servicio.IClienteServicio;
import frgp.utn.edu.ar.servicio.IPrestamoServicio;
import frgp.utn.edu.ar.utiles.Util;

@Controller
public class PrestamoController {
	@Autowired
	public  IPrestamoServicio service;
	/*@Autowired
	public IClienteServicio clienteservicio;*/
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (IPrestamoServicio) ctx.getBean("serviceBean");
	}
	
	@RequestMapping("/Prestamos.html")
	public ModelAndView irPrestamos(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaPrestamos", service.listadoPrestamos());
		MV.setViewName("Prestamos"); 
		return MV;
	}
	
	@RequestMapping("/AltaPrestamos.html")
	public ModelAndView irAltaPrestamos(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaLibrosbiblioteca", service.listadolibrosselect());
		MV.setViewName("AltaPrestamos"); 
		return MV;
	}
	
	
	@RequestMapping("/insertPrestamos.html")
	public ModelAndView insertPrestamos(Integer selectLibro,String txtFecha,Integer txtDias,String txtDNI){
		ModelAndView MV = new ModelAndView();
	String Message="";
	
		
		try{
			ECliente Cliente = service.ExisteCliente(txtDNI);
			
			if(Cliente!= null) {
				EBiblioteca Biblioteca = service.ObtenerBiblioteca(selectLibro);
				service.altaPrestamo(new EPrestamo(Biblioteca ,Util.convertStringToDate(txtFecha), txtDias,Cliente));
				
				Biblioteca.setEstado("Prestado");
				
				service.EditarBiblioteca(Biblioteca);
				
	            Message="Prestamo Ingresado con Exito!!";
			}
			
			else {
				Message="Cliente Inexistente";
			}
			
			
		
		}
		catch(Exception e)
		{
			Message="No se pudo Ingresar el Prestamo";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.setViewName("AltaPrestamos"); 
		return MV;
	}
	
	@RequestMapping("/bajaPrestamos.html")
	public ModelAndView deletePrestamos(Integer ID, Integer IDbiblioteca){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
			
			try{
				EPrestamo prestamos = new EPrestamo();
				prestamos.setId(ID);
				
				EBiblioteca Biblioteca = service.ObtenerBibliotecabyid(IDbiblioteca);				
				Biblioteca.setEstado("En biblioteca");
				
				service.EditarBiblioteca(Biblioteca);
				service.bajaPrestamo(prestamos);
				
	            Message="¡Autor eliminado con éxito!";
			
			}
			catch(Exception e)
			{
				Message="No se pudo eliminar el autor";
				e.printStackTrace();
			}
			
			MV.addObject("Mensaje", Message);	
			MV.addObject("listaPrestamos", service.listadoPrestamos());
			MV.setViewName("Prestamos"); 
			return MV;
	}
	
	@RequestMapping("/modificarPrestamo.html")
	public ModelAndView modificarPrestamos(Integer ID,Integer txtDias){
		ModelAndView MV = new ModelAndView();
		String Message="";
		
		try{
			
			EPrestamo prestamo = service.obtenerPrestamobyID(ID);
			
			if (prestamo.getCantDias()<txtDias) {
				
				prestamo.setCantDias(txtDias);
				
				service.EditarPrestamo(prestamo);
				
	            Message="¡Prestamo modificado con éxito!";
			} else {
				Message="¡Cantidad de dias menor al prestamo actual!";
				
			}
			
		
		}
		catch(Exception e)
		{
			Message="No se pudo modificar el Autor";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("listaPrestamos", service.listadoPrestamos());
		MV.setViewName("Prestamos"); 
		return MV;
	}
}
