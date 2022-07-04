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
import frgp.utn.edu.ar.entidades.EAutor;
import frgp.utn.edu.ar.entidades.EBiblioteca;
import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.EGenero;
import frgp.utn.edu.ar.entidades.ELibro;
import frgp.utn.edu.ar.entidades.ENacionalidad;
import frgp.utn.edu.ar.servicio.IPrestamoServicio;
import frgp.utn.edu.ar.utiles.Util;

@Controller
public class PrestamoController {
	@Autowired
	public  IPrestamoServicio service;
	
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
	
	
	@RequestMapping("/insertPrestamos.html")
	public ModelAndView insertPrestamos(String selectLibro,String txtFecha,Integer txtDias,String txtDNI){
		ModelAndView MV = new ModelAndView();
	String Message="";
	
		
		try{
			ENacionalidad nac = new ENacionalidad();
			nac.setDescripcion("Arabe");
			ECliente Cliente = new ECliente();
			Cliente.setNombre("Regina");
			Cliente.setDni(txtDNI);
			Cliente.setApellido("laurentino");
			Cliente.setEmail("zarasa@gamil.com");
			Cliente.setFechaNacimiento(Util.convertStringToDate(txtFecha));
			Cliente.setLocalidad("tigre");
			Cliente.setNacionalidad(nac);
			Cliente.setTelefono("123456");
			Cliente.setDireccion("zarasa 123");
			
		/*	Integer dias = Integer.parseInt (txtDias);*/
			
			/*COMPROBAR DNI EN BASE DE DATOS*/
			
			
			/*COMPROBAR QUE NO TENGA PRESTAMOS*/
			
			/*BUSCAR EL ID DEL LIBRO*/
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
			Libro_ID.setEstado(2);
			Libro_ID.setFechaAlta(Util.convertStringToDate(txtFecha));
		
			
		
			service.altaPrestamo(new EPrestamo(Libro_ID ,Util.convertStringToDate(txtFecha), txtDias,Cliente));
			
            Message="Prestamo Ingresado con Exito!!";
		
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
