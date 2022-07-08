package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.servicio.ILibroServicio;
import frgp.utn.edu.ar.utiles.Util;

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
		MV.addObject("listaLibros", service.listadoLibros());
		MV.setViewName("Biblioteca"); 
		return MV;
	}
	
	@RequestMapping("/AltaBiblioteca.html")
	public ModelAndView irAltaBiblioteca(){
		ModelAndView MV = new ModelAndView();
		Object aux=service.listadoLibros();
		System.out.print(aux);
		MV.addObject("listaLibros", service.listadoLibros());
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
	
	@RequestMapping("/insertLibro.html")
	public ModelAndView insertLibros(String txtTitulo,String txtFecha,String txtIdioma,Integer txtCant,Integer selectAutores,String txtDesc, Integer[] chkGenero){
		ModelAndView MV = new ModelAndView();
	String Message="";
		
		try{
		
			ArrayList<EGenero> listaGeneros = new ArrayList<EGenero>();
			for (Integer idGenero : chkGenero ) {
				listaGeneros.add(service.getGenero(idGenero));
			}
			service.altaLibro(new ELibro(txtTitulo, Util.convertStringToDate(txtFecha) ,txtIdioma,txtCant,service.getAutor(selectAutores),txtDesc,listaGeneros));
			
            Message="Libro Ingresado con Exito!!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo Ingresar el libro";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("Generos", service.listadoGenero());
		MV.addObject("Autores", service.listadoAutores());
		MV.setViewName("AltaLibros"); 
		return MV;
	}
	
	
}