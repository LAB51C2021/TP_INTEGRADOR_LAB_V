package src.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Cuenta;
import models.Pais;
import models.Persona;
import models.Provincia;
import models.Usuario;
import src.hibernate.ClienteHibernate;
import src.services.IEntityService;

@Controller
public class ClienteController {

	@Autowired
	private IEntityService<Persona> personaService;
	
	@Autowired
	private IEntityService<Cuenta> cuentaService;
	
	@Autowired
	private IEntityService<Pais> paisService;
	
	@Autowired
	private IEntityService<Provincia> provinciaService;
	
	@RequestMapping("Clientes.html")
	public ModelAndView Clientes(HttpServletRequest request, Model modelo)
	{
		ModelAndView MV = new ModelAndView();
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) 
    	{
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		List datos = personaService.GetAll("EsCliente = 1");
    		
    		modelo.addAttribute("clienteListado", datos);
    		
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
		
		MV.addObject("provincias", provinciaService.GetAll());
		MV.addObject("paises", paisService.GetAll());
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	
    	if (sessionActiva.getAttribute("sessionUser") != null) 
    	{
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if (request.getParameter("idCliente") != null) 
    		{
    			String idPersona = request.getParameter("idCliente");
    			int id = Integer.parseInt(idPersona);
        		        		
        		Persona datos = personaService.FirstOrDefault(id);
        		MV.addObject("cliente", datos);
        		
    		}
    		
    		MV.setViewName("ClienteDetalle");   
    	}
    	else 
    	{
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
    			
    			Persona datos = new Persona();
    			if(id != 0) {
    				datos = personaService.FirstOrDefault(id);
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
        		
        		String respuesta;
        		if(id != 0) {
        			personaService.Update(datos);
        			respuesta = "Se actualizo el cliente correctamente";
        		}else {
        			
        			Usuario userSave = new Usuario();
        			userSave.setHabilitado(true);
        			String username = datos.getNombre_Apellido().split(" ")[0];
        			userSave.setNombre(username);
        			userSave.setClave("123");
        			userSave.setPersona(datos);

        			datos.setUsuario(userSave);
        			personaService.Add(datos);
        			respuesta = "Se agregó el cliente correctamente";
        		}
        		
        		MV.addObject("respuesta", respuesta);
        		
        		MV.setViewName("EditCliente");   
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
    			String respuesta;
    			boolean estado = Boolean.parseBoolean(request.getParameter("habilitado"));
    			
        		Persona datos = personaService.FirstOrDefault(id);
        		datos.setHabilitado(estado);
        		datos.getUsuario().setHabilitado(estado);
        		
        		List<Cuenta> cuentas = cuentaService.GetAll("Id_Cuenta = " + datos.getUsuario().getId_Usuario());
        		
        		for (Cuenta cnt: cuentas) {
        		      cnt.setHabilitado(estado);
        		      cuentaService.Update(cnt);
    		    }
        		
        		personaService.Update(datos);
        		if(!estado) {
        			respuesta = "Se des habilito al cliente correctamente";        			
        		}else {
        			respuesta = "Se habilito el cliente correctamente";
        		}
        		MV.addObject("respuesta", respuesta);
        		
        		MV.setViewName("EditCliente");  
    		}
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
	
	@RequestMapping(value = "ValidaDuplicateDNI.html", method = RequestMethod.GET)
	public ModelAndView ValidacionDNI(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ValidaDuplicateDNI");
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("dni") != null) {
    			String dni = request.getParameter("dni");
        		        		
        		ClienteHibernate ClienteHibernate = new ClienteHibernate();
        		boolean existe = ClienteHibernate.ValidateDNI(dni);
        		
        		if(existe) {
        			MV.addObject("error", "No se pudo dar de alta correctamente al cliente, porque ya existe el DNI en la base.");	
        		}
    		}
    	}
    	return MV;
	}
}
