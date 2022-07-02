package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.EPrestamo;
import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ENacionalidad;
import frgp.utn.edu.ar.servicio.IPrestamoServicio;
import frgp.utn.edu.ar.utiles.Util;

public class PrestamoController {
	@Autowired
	public  IPrestamoServicio service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (IPrestamoServicio) ctx.getBean("serviceBean");
	}
	
	
	@RequestMapping("/insertPrestamos.html")
	public ModelAndView insertPrestamos(String selectLibro,String txtFecha,String txtDias,String txtDNI){
		ModelAndView MV = new ModelAndView();
	String Message="";
	
		
		try{
			ECliente Cliente;
			Integer dias = Integer.parseInt (txtDias);
			
			/*COMPROBAR DNI EN BASE DE DATOS*/
			
			/*COMPROBAR QUE NO TENGA PRESTAMOS*/
			
			/*BUSCAR EL ID DEL LIBRO*/
			EBiblioteca Libro;
		
		/*	service.altaPrestamo(new EPrestamo(Libro ,Util.convertStringToDate(txtFecha), dias,
					Cliente));*/
			
            Message="Cliente Ingresado con Exito!!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo Ingresar el Cliente";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.setViewName("AltaClientes"); 
		return MV;
	}
	
	
}
