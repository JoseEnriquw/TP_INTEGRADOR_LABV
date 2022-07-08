package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.servicio.IBibliotecaServicio;
import frgp.utn.edu.ar.servicio.ILibroServicio;
import frgp.utn.edu.ar.utiles.Util;

@Controller
public class BibliotecaController {
	@Autowired
	public  IBibliotecaServicio service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (IBibliotecaServicio) ctx.getBean("serviceBean");
	}
	
	@RequestMapping("/Biblioteca.html")
	public ModelAndView irBiblioteca(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaLibros", service.listadoLibro());
		MV.addObject("listaBibliotecas", service.listadoBiblioteca());
		MV.setViewName("Biblioteca"); 
		return MV;
	}
	
	@RequestMapping("/AltaBiblioteca.html")
	public ModelAndView irAltaBiblioteca(){
		ModelAndView MV = new ModelAndView();
		Object aux=service.listadoLibro();
		System.out.print(aux);
		MV.addObject("listaLibros", service.listadoLibro());
		MV.addObject("Mensaje", null);
		MV.setViewName("AltaBiblioteca"); 
		return MV;
	}
	
/*	@RequestMapping("/bajaBiblioteca.html")
	public ModelAndView deleteLibros(Integer ID){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
			
			try{
				ELibro libro = new ELibro();
				libro.setId(ID);
				service.bajaLibro(libro);
				
	            Message="¡Libro eliminado con éxito!";
			
			}
			catch(Exception e)
			{
				Message="No se pudo eliminar el libro";
				e.printStackTrace();
			}
			
			MV.addObject("Mensaje", Message);
			MV.addObject("listaLibros", service.listadoLibros());
			MV.addObject("Generos", service.listadoGenero());
			MV.addObject("Autores", service.listadoAutores());
			MV.setViewName("Libros"); 
			return MV;
	}*/
	
	@RequestMapping("/insertBiblioteca.html")
	public ModelAndView insertBiblioteca(Integer selectLibro, String txtFecha, String selectEstado){
		ModelAndView MV = new ModelAndView();
	String Message="";
		
		try{
		
			
			service.altaBiblioteca(new EBiblioteca(Util.convertStringToDate(txtFecha),selectEstado,service.obtenerLibro(selectLibro)));
			
            Message="¡Biblioteca ingresada con éxito!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo ingresar la biblioteca";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);

		MV.setViewName("AltaBiblioteca"); 
		return MV;
	}
	
	
}