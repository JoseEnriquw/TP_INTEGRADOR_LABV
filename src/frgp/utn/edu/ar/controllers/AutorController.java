package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.entidades.ENacionalidad;
import frgp.utn.edu.ar.servicio.IAutorServicio;


@Controller
public class AutorController {
	@Autowired
	public  IAutorServicio service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (IAutorServicio) ctx.getBean("serviceBeanAutor");
	}
	
	@RequestMapping("/Autores.html")
	public ModelAndView irAutores(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("Mensaje", null);
		MV.addObject("listaAutores", service.listadoAutores());
		MV.setViewName("Autores"); 
		return MV;
	}
	
	@RequestMapping("/AltaAutores.html")
	public ModelAndView irAltaAutores(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("Mensaje", null);
		MV.setViewName("AltaAutores"); 
		return MV;
	}
	
	@RequestMapping("/bajaAutores.html")
	public ModelAndView deleteAutores(Integer ID){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
			
			try{
				EAutor autor = new EAutor();
				autor.setId(ID);
				service.bajaAutor(autor);
				
	            Message="¡Autor eliminado con éxito!";
			
			}
			catch(Exception e)
			{
				Message="No se pudo eliminar el autor";
				e.printStackTrace();
			}
			
			MV.addObject("Mensaje", Message);
			MV.addObject("listaAutores", service.listadoAutores());
			MV.setViewName("Autores"); 
			return MV;
	}
	
	@RequestMapping("/insertAutores.html")
	public ModelAndView insertAutores(String txtNombre,String txtApellido,String txtMail,String selectNacionalidad){
		ModelAndView MV = new ModelAndView();
	String Message="";
		
		try{
			
			service.altaAutor(new EAutor(txtNombre,txtApellido,new ENacionalidad(selectNacionalidad),txtMail));
			
            Message="Autor Ingresado con Exito!!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo Ingresar el Autor";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.setViewName("AltaAutores"); 
		return MV;
	}
	
	@RequestMapping("/modificarAutores.html")
	public ModelAndView modificarAutores(String txtNombre,String txtApellido,String txtMail,String selectNacionalidad, Integer ID){
		ModelAndView MV = new ModelAndView();
		String Message="";
		
		try{
		
			service.modificarAutor(new EAutor(ID,txtNombre,txtApellido,new ENacionalidad(selectNacionalidad),txtMail));
			
            Message="¡Autor modificado con éxito!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo modificar el Autor";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("listaAutores", service.listadoAutores());
		MV.setViewName("Autores"); 
		return MV;
	}
}
