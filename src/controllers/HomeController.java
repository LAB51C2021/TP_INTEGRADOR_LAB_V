package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import helper.ViewHelper;
import hibernate.CuentaHibernate;
import models.Cuenta;
import models.Persona;
import models.Usuario;

@Controller
public class HomeController {

    @RequestMapping("HomeCliente.html")
	public ModelAndView Home(HttpServletRequest request)
	{
    	ModelAndView MV = new ModelAndView();
    	//obtengo variable de session
    	HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    		
    		CuentaHibernate cuentaHibernate = new CuentaHibernate();
    		List datos = cuentaHibernate.GetAllByUser(user.getId_Usuario());
    		
    		MV.addObject("lista", datos);
    	}
    	    	
    	//redirecciono a donde corresponda
		MV.setViewName(ViewHelper.SetViewNameByUser(user));
		
		return MV;
	}
    
    @RequestMapping("HomeRepresentante.html")
	public ModelAndView HomeBanco(HttpServletRequest request)
	{
    	//obtengo variable de session
    	HttpSession sessionActiva = request.getSession();
    	Usuario user = null;
    	if(sessionActiva.getAttribute("sessionUser") != null) {
    		user = (Usuario) sessionActiva.getAttribute("sessionUser");
    	}
    	
    	//redirecciono a donde corresponda
		ModelAndView MV = new ModelAndView();		
		MV.setViewName(ViewHelper.SetViewNameByUser(user));
		return MV;
	}
}
