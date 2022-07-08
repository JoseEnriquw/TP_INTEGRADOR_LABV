package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Convert;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.spi.ConversionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.springframework.web.bind.annotation.PathVariable;
import frgp.utn.edu.ar.entidades.EUsuario;
import frgp.utn.edu.ar.servicio.IUsuarioServicio;

@Controller
public class UserController {

	@Autowired
	public  IUsuarioServicio service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (IUsuarioServicio) ctx.getBean("serviceBeanUser");
	}
	
	//Inicio
	
	@RequestMapping("/Login.html")
	public ModelAndView irLogin(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login"); 
		return MV;
	}
	
	@RequestMapping(value ="validar_usuario.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarUsuario(String nombreU, String passU){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
		
		try{
			
			EUsuario user = service.obtenerUnRegistro(nombreU);
			if(user==null)
			{
				Message=" El usuario "+nombreU+" no existe";
			}
			else if(user.getNombreU().equals(nombreU)) 
			{
				MV.setViewName("Biblioteca"); 
				return MV;
			}
			else {
				Message=" Contraseña incorrecta";
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.setViewName("Login"); 
		return MV;
		
	}
	
	@RequestMapping("/Prestamos.html")
	public ModelAndView irPrestamos(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos"); 
		return MV;
	}
	
	@RequestMapping("/LogOut.html")
	public ModelAndView irLogOut(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("LogOut"); 
		return MV;
	}
	
	@RequestMapping("/AltaPrestamos.html")
	public ModelAndView irAltaPrestamos(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaPrestamos"); 
		return MV;
	}
	
	@RequestMapping("/AltaUsuario.html")
	public ModelAndView irAltaUsuarios(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaUsuario"); 
		return MV;
	}
	
	
	
	
}
