package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import frgp.utn.edu.ar.entidades.EUsuario;
import frgp.utn.edu.ar.servicio.IUsuarioServicio;
import frgp.utn.edu.ar.utiles.Util;

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
	public ModelAndView validarUsuario(String nombreU, String passU, HttpServletResponse response){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
		
		try{
			
			EUsuario user = service.obtenerUnRegistro(nombreU);
			if(user==null)
			{
				Message=" El usuario "+nombreU+" no existe";
			}
			else if(user.getNombreU().equals(nombreU) && user.getPassU().equals(passU)) 
			{
				MV.addObject("Usuario", nombreU);
				Cookie userCookie = new Cookie("userCookieAlejandria", nombreU);
				userCookie.setMaxAge(60*60*24);
				response.addCookie(userCookie);
				MV.setViewName("../../Index"); 
				return MV;
			}
			else {
				Message="Usuario o contraseņa incorrecta";
			}
		
		}
		catch(Exception e)
		{
			Message="Usuario o contraseņa incorrecta";
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.setViewName("Login"); 
		return MV;
		
	}
	
	@RequestMapping("/LogOut.html")
	public ModelAndView irLogOut(HttpServletResponse response){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("LogOut"); 
		return MV;
	}

	@RequestMapping("/LogOutAceptar.html")
	public ModelAndView LogOutAceptar(HttpServletResponse response){
		ModelAndView MV = new ModelAndView();
		Cookie userCookie = new Cookie("userCookieAlejandria", null);
		userCookie.setMaxAge(0);
		response.addCookie(userCookie);
		MV.setViewName("Login"); 
		return MV;
	}
	
	@RequestMapping("/Usuarios.html")
	public ModelAndView irClientes(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaUsuarios", service.listadoUsuarios());
		MV.setViewName("Usuarios"); 
		return MV;
	}

	@RequestMapping("/AltaUsuario.html")
	public ModelAndView irAltaUsuarios(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaUsuarios"); 
		return MV;
	}
	
	@RequestMapping("/bajaUsuario.html")
    public ModelAndView deleteUsuarios(Integer ID){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
			
			try{
				service.bajaUsuario(ID);
				
	            Message="ĄUsuario eliminado con éxito!";
			
			}
			catch(Exception e)
			{
				Message="No se pudo eliminar el Usuario";
				e.printStackTrace();
			}
			
			MV.addObject("Mensaje", Message);
			MV.addObject("listaUsuarios", service.listadoUsuarios());
			MV.setViewName("Usuarios"); 
			return MV;
	}
	
	@RequestMapping("/modificarUsuario.html")
	public ModelAndView editarUsuarios(Integer ID, String txtNombre, String txtPass){
		ModelAndView MV = new ModelAndView();
		String Message="";
	
		try {
			service.modificarUsuario(new EUsuario(ID,txtNombre, txtPass));
			
		Message="!Usuario modificado con éxito!";
		} catch (Exception e) {
			Message="No se pudo modificar el Usuario";	
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("listaUsuarios", service.listadoUsuarios());
		MV.setViewName("Usuarios"); 
		return MV;
	}
	
	@RequestMapping("/insertUsuarios.html")
	public ModelAndView insertUsuarios(String txtNombre,String txtPass){
		ModelAndView MV = new ModelAndView();
	String Message="";
		
		try{
		
			service.altaUsuario(new EUsuario(txtNombre,txtPass));
			
            Message="Usuario Ingresado con Exito!!";
		
		}
		catch(Exception e)
		{
			Message="No se pudo agregar el Usuario";	
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.setViewName("AltaUsuarios"); 
		return MV;
	}
	
}
