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
	@Autowired
	public IClienteServicio clienteservicio;
	
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
		MV.setViewName("AltaPrestamos"); 
		return MV;
	}
	
	
	@RequestMapping("/insertPrestamos.html")
	public ModelAndView insertPrestamos(String selectLibro,String txtFecha,Integer txtDias,String txtDNI){
		ModelAndView MV = new ModelAndView();
	String Message="";
	
		
		try{
			ECliente Cliente = clienteservicio.obtenerUnRegistro(txtDNI);
			
			if(clienteservicio.obtenerUnRegistro(txtDNI)!= null) {
				
				ENacionalidad nac = new ENacionalidad();
				nac.setDescripcion("Arabe");				
				
				/*COMPROBAR QUE NO TENGA PRESTAMOS*/
				
				ELibro Libro_Titulo = new ELibro();
				Libro_Titulo.setTitulo(selectLibro);
				Libro_Titulo.setCantPaginas(500);
				EAutor Autor = new EAutor();
				Autor.setNombre("");
				Autor.setApellido("");
				Autor.setEmail("");
				Autor.setNacionalidad(nac);			
				Libro_Titulo.setAutor(Autor);
				Libro_Titulo.setDescripcion("Libro epico");
				Libro_Titulo.setFechaLanzamiento(Util.convertStringToDate(txtFecha));
				
				EGenero genero = new EGenero();
				genero.setDescripcion("Aventura");
				
				
				List<EGenero> lisgenero = new ArrayList<EGenero>();
				lisgenero.add(genero);
				
				Libro_Titulo.setGeneros(lisgenero);
				Libro_Titulo.setIdioma("Ingles");
				
							
				
				EBiblioteca Libro_ID = new EBiblioteca();
				Libro_ID.setLibro(Libro_Titulo);
				Libro_ID.setEstado("Prestado");
				Libro_ID.setFechaAlta(Util.convertStringToDate(txtFecha));
			
				
			
				service.altaPrestamo(new EPrestamo(Libro_ID ,Util.convertStringToDate(txtFecha), txtDias,Cliente));
				
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
	
	
}
