package frgp.utn.edu.ar.controllers;

import java.util.Date;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.ECliente;
import frgp.utn.edu.ar.entidades.ENacionalidad;
import frgp.utn.edu.ar.servicio.IClienteServicio;
import frgp.utn.edu.ar.utiles.Util;

@Controller
public class ClienteController {

	@Autowired
	public  IClienteServicio service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		
		this.service = (IClienteServicio) ctx.getBean("serviceBean");
	}
	
	
	//Inicio
	
	@RequestMapping("Clientes.html")
	public ModelAndView irClientes(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaClientes", service.listadoClientes());
		MV.setViewName("Clientes"); 
		return MV;
	}
	
	@RequestMapping("/AltaClientes.html")
	public ModelAndView irAltaClientes(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("AltaClientes"); 
		return MV;
	}
	
	@RequestMapping("/insertClientes.html")
	public ModelAndView insertClientes(String txtNombre,String txtApellido,String txtMail,String txtTelefono,String txtDireccion,String txtLocalidad,
			String txtDni,String txtFecha, String selectNacionalidad){
		ModelAndView MV = new ModelAndView();
	String Message="";
		
		try{
		
			service.altaCliente(new ECliente(txtDni,txtNombre,txtApellido,new ENacionalidad(selectNacionalidad),txtMail,
					txtDireccion,txtLocalidad,txtTelefono, Util.convertStringToDate(txtFecha)
					));
			
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
