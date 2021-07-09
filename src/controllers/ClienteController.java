package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import helper.ViewHelper;
import hibernate.ClienteHibernate;
import models.Pais;
import models.Persona;
import models.Provincia;
import models.Usuario;

@Controller
public class ClienteController {

	@RequestMapping("Clientes.html")
	public ModelAndView Clientes(HttpServletRequest request)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		ClienteHibernate ClienteHibernate = new ClienteHibernate();
    		List datos = ClienteHibernate.GetAllClientes();
    		
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
        		        		
        		Persona datos = ClienteHibernate.GetCliente(id);
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
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCliente") != null) {
    			String idPersona = request.getParameter("idCliente");
    			int id = Integer.parseInt(idPersona);
        		        		
        		ClienteHibernate ClienteHibernate = new ClienteHibernate();
        		Persona datos = ClienteHibernate.GetCliente(id);
        		if(request.getAttribute("nombre_apellido") != null)
        			datos.setNombre_Apellido(request.getAttribute("nombre_apellido").toString());        		
        		if(request.getAttribute("dni") != null)
        			datos.setDni(request.getAttribute("dni").toString());    
        		/*if(request.getAttribute("fechaNac") != null)
        			datos.setFecha_Nacimiento(request.getAttribute("fechaNac").toString());    */
        		if(request.getAttribute("sexo") != null)
        			datos.setSexo(request.getAttribute("sexo").toString());    
        		if(request.getAttribute("provincia") != null) {
        			String idProv = (String) request.getAttribute("provincia");
        			int intIdProv = Integer.parseInt(idProv);
        			Provincia prov = new Provincia(intIdProv);
        			datos.setProvincia(prov);    		
        		}
        		if(request.getAttribute("pais") != null) {
        			String idPais = (String) request.getAttribute("pais");
        			int intIdPais = Integer.parseInt(idPais);
        			Pais pais = new Pais(intIdPais);
        			datos.setPais(pais);   			
        		}
        		
        		ClienteHibernate.Actualizar(datos);
        		response.sendRedirect("Clientes.html");
    		}
    	}else {
    		MV.setViewName("Login");    		
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
