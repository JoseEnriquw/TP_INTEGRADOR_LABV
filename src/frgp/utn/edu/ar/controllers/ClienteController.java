package frgp.utn.edu.ar.controllers;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidades.EAutor;
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
		
		this.service = (IClienteServicio) ctx.getBean("serviceBeanCliente");
	}
	
	@RequestMapping("/Clientes.html")
	public ModelAndView irClientes(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("Nacionalidades", service.listadoNacionalidades());
		MV.addObject("listaClientes", service.listadoClientes());
		MV.setViewName("Clientes"); 
		return MV;
	}

	@RequestMapping("/bajaCliente.html")
    public ModelAndView deleteAutores(Integer ID){
		
		ModelAndView MV = new ModelAndView();
		String Message="";
			
			try{
				service.bajaCliente(ID);
				
	            Message="?Cliente eliminado con ?xito!";
			
			}
			catch(Exception e)
			{
				Message="No se pudo eliminar el cliente";
				e.printStackTrace();
			}
			
			MV.addObject("Mensaje", Message);
			MV.addObject("listaClientes", service.listadoClientes());
			MV.addObject("Nacionalidades", service.listadoNacionalidades());
			MV.setViewName("Clientes"); 
			return MV;
	}
	
	@RequestMapping("/modificarCliente.html")
	public ModelAndView editarClientes(String txtNombre,String txtApellido,String txtMail,String txtTelefono,String txtDireccion,String txtLocalidad,
			String txtDni,String txtFecha, Integer selectNacionalidad,Integer ID){
		ModelAndView MV = new ModelAndView();
		String Message="";
	
		try {
			service.modificarCliente(new ECliente(ID,txtDni,txtNombre,txtApellido,service.getNacionalidad(selectNacionalidad),txtMail,
						txtDireccion,txtLocalidad,txtTelefono, Util.convertStringToDate(txtFecha)
						));
			
		Message="!Cliente modificado con ?xito!";
		} catch (Exception e) {
			Message="No se pudo modificar el Cliente";	
			e.printStackTrace();
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("listaClientes", service.listadoClientes());
		MV.addObject("Nacionalidades", service.listadoNacionalidades());
		MV.setViewName("Clientes"); 
		return MV;
	}
	
	@RequestMapping("/AltaClientes.html")
	public ModelAndView irAltaClientes(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("Mensaje", null);
		MV.addObject("Nacionalidades", service.listadoNacionalidades());
		MV.setViewName("AltaClientes"); 
		return MV;
	}
	
	@RequestMapping("/insertClientes.html")
	public ModelAndView insertClientes(String txtNombre,String txtApellido,String txtMail,String txtTelefono,String txtDireccion,String txtLocalidad,
			String txtDni,String txtFecha, Integer selectNacionalidad){
		ModelAndView MV = new ModelAndView();
	String Message="";
		
		try{
		
			service.altaCliente(new ECliente(txtDni,txtNombre,txtApellido,service.getNacionalidad(selectNacionalidad),txtMail,
					txtDireccion,txtLocalidad,txtTelefono, Util.convertStringToDate(txtFecha)
					));
			
            Message="Cliente Ingresado con Exito!!";
		
		}
		catch(Exception e)
		{
			if ("org.springframework.dao.DataIntegrityViolationException" == e.getClass().getName()) {
				String key =e.getCause().getCause().toString().split("'")[3].toString(); 
				if ( key.equals("cliente.UK_jlcg5nhnauli1hu4ojldsedaw")) {
					Message="El DNI n? " + e.getCause().getCause().toString().split("'")[1].toString() + " ya se encuentra registrado!"; 
				}
				else {
					Message="Esta correo (" + e.getCause().getCause().toString().split("'")[1].toString() + ") ya se encuentra registrado!";
				}
			}
		}
		
		MV.addObject("Mensaje", Message);
		MV.addObject("Nacionalidades", service.listadoNacionalidades());
		MV.setViewName("AltaClientes"); 
		return MV;
	}
	
}
