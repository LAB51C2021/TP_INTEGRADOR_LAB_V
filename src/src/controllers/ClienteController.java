package src.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import helper.ViewHelper;
import models.Pais;
import models.Persona;
import models.Provincia;
import models.Usuario;
import src.hibernate.ClienteHibernate;
import src.servicesImplementation.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("Clientes.html")
	public ModelAndView Clientes(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		//ClienteHibernate ClienteHibernate = new ClienteHibernate();
    		//List datos = ClienteHibernate.GetAllClientes();
    		
    		List<Object> datos = clienteService.getAll();
    		
    		MV.addObject("clientes", datos);
    		MV.setViewName("Clientes");
    	}else {
    		MV.setViewName("Login");
    	}
		
		return MV;
	}
	
	@RequestMapping("Editar.html")
	public ModelAndView Cliente(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		ClienteHibernate ClienteHibernate = new ClienteHibernate();
		MV.addObject("provincias", ClienteHibernate.getProvincias());
		MV.addObject("paises", ClienteHibernate.getPaises());
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCliente") != null) {
    			String idPersona = request.getParameter("idCliente");
    			int id = Integer.parseInt(idPersona);
        		        		
        		//Persona datos = ClienteHibernate.GetCliente(id);
        		Persona datos = clienteService.get(id);
        		MV.addObject("cliente", datos);
        		
    		}
    		MV.setViewName("ClienteDetalle");   
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
	
	@RequestMapping(value = "Grabar.html", method = RequestMethod.POST)
	public ModelAndView Grabar(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");   
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCliente") != null) {
    			String idPersona = request.getParameter("idCliente");
    			int id = Integer.parseInt(idPersona);
    			
    			ClienteHibernate ClienteHibernate = new ClienteHibernate();
    			Persona datos = new Persona();
    			if(id != 0) {
    				datos = ClienteHibernate.GetCliente(id);
    			}
    			
        		
        		if(request.getParameter("nombre_apellido") != null)
        			datos.setNombre_Apellido(request.getParameter("nombre_apellido").toString());        		
        		if(request.getParameter("dni") != null)
        			datos.setDni(request.getParameter("dni").toString());    
        		if(request.getParameter("fechaNac") != null) {
        			String date = request.getParameter("fechaNac").toString();
        			LocalDate localDate = LocalDate.parse(date);
        			datos.setFecha_Nacimiento(localDate);		
        		}
        		if(request.getParameter("sexo") != null)
        			datos.setSexo(request.getParameter("sexo").toString());    
        		if(request.getParameter("direccion") != null)
        			datos.setDireccion(request.getParameter("direccion").toString());    
        		if(request.getParameter("localidad") != null)
        			datos.setLocalidad(request.getParameter("localidad").toString());    
        		if(request.getParameter("provincia") != null) {
        			String idProv = (String) request.getParameter("provincia");
        			int intIdProv = Integer.parseInt(idProv);
        			Provincia prov = new Provincia(intIdProv);
        			datos.setProvincia(prov);    		
        		}
        		if(request.getParameter("pais") != null) {
        			String idPais = (String) request.getParameter("pais");
        			int intIdPais = Integer.parseInt(idPais);
        			Pais pais = new Pais(intIdPais);
        			datos.setPais(pais);   			
        		}
        		
        		datos.setEsCliente(true);
        		datos.setHabilitado(true);
        		if(id != 0) {
        			ClienteHibernate.Actualizar(datos);
        		}else {
        			ClienteHibernate.Grabar(datos);
        		}
        		response.sendRedirect("Clientes.html");
    		}
    	}
		
		return MV;
	}
	
	@RequestMapping(value = "Eliminar.html", method = RequestMethod.POST)
	public ModelAndView Eliminar(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCliente") != null) {
    			String idPersona = request.getParameter("idCliente");
    			int id = Integer.parseInt(idPersona);
        		        		
        		ClienteHibernate ClienteHibernate = new ClienteHibernate();
        		Persona datos = ClienteHibernate.GetCliente(id);
        		datos.setHabilitado(false);
        		ClienteHibernate.Actualizar(datos);
        		MV.setViewName("Clientes");
    		}
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
}
