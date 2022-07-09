package frgp.utn.edu.ar.controllers;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.servicio.ILibroServicio;
import frgp.utn.edu.ar.utiles.Util;


@Controller
public class LibroController {
	@Autowired
	public  ILibroServicio service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (ILibroServicio) ctx.getBean("serviceBean");
	}
	
	@RequestMapping("/Todosloslibros.html")
	public ModelAndView irLibros(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaLibros", service.listadoLibros());
		MV.addObject("Generos", service.listadoGenero());
		MV.addObject("Autores", service.listadoAutores());
		MV.setViewName("Todosloslibros"); 
		return MV;
	}
	
	@RequestMapping("/AltaLibros.html")
	public ModelAndView irAltaLibros(){
		ModelAndView MV = new ModelAndView();
		Object aux=service.listadoGenero();
		System.out.print(aux);
		MV.addObject("Generos", service.listadoGenero());
		MV.addObject("Autores", service.listadoAutores());
		MV.addObject("Mensaje", null);
		MV.setViewName("AltaLibros"); 
		return MV;
	}
	
	@RequestMapping("/bajaLibros.html")
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
			MV.setViewName("Todosloslibros"); 
			return MV;
	}
	
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
		MV.addObject("listaLibros", service.listadoLibros());
		MV.setViewName("AltaLibros"); 
		return MV;
	}
	
	@RequestMapping("/modificarLibros.html")
	public ModelAndView modificarLibros(String txtNombre,String txtApellido,String txtMail,String selectNacionalidad, Integer ID){
		ModelAndView MV = new ModelAndView();
		String Message="";
		
		try{
		
			//service.modificarLibro(new ELibro(ID,txtNombre,txtApellido,new ENacionalidad(selectNacionalidad),txtMail));
			
            Message="¡Libro modificado con éxito!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo modificar el libro";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("listaLibros", service.listadoLibros());
		MV.addObject("Generos", service.listadoGenero());
		MV.addObject("Autores", service.listadoAutores());
		MV.setViewName("Libros"); 
		return MV;
	}
}
