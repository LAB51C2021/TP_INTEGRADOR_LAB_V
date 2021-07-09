package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hibernate.ClienteHibernate;
import models.Persona;
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
		
		HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		if(request.getParameter("idCliente") != null) {
    			String idPersona = request.getParameter("idCliente");
    			int id = Integer.parseInt(idPersona);
        		        		
        		ClienteHibernate ClienteHibernate = new ClienteHibernate();
        		Persona datos = ClienteHibernate.GetCliente(id);
        		MV.addObject("cliente", datos);
        		MV.setViewName("ClienteDetalle");
    		}else {
    			MV.setViewName("Clientes");    			
    		}
    	}else {
    		MV.setViewName("Login");    		
    	}
		
		return MV;
	}
}
